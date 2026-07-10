package com.bancodealimentos26.donaciones26.service;


import com.bancodealimentos26.donaciones26.dto.DonacionDTO;
import java.util.stream.Collectors;
import com.bancodealimentos26.donaciones26.model.Alimento;
import com.bancodealimentos26.donaciones26.model.Donacion;
import com.bancodealimentos26.donaciones26.model.Usuario;
import com.bancodealimentos26.donaciones26.repository.AlimentoRepository;
import com.bancodealimentos26.donaciones26.repository.DonacionRepository;
import com.bancodealimentos26.donaciones26.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



@Service
public class DonacionService {

    @Autowired
    private DonacionRepository donacionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AlimentoRepository alimentoRepository;

    public List<DonacionDTO> listarDonaciones()
    
    
    {

        

    return donacionRepository.findAll()
            .stream()
            .map(donacion -> {

                Long usuarioId = donacion.getUsuario() != null
                        ? donacion.getUsuario().getId()
                        : null;

                String usuarioNombre = donacion.getUsuario() != null
                        ? donacion.getUsuario().getNombre()
                        : null;

                Long alimentoId = donacion.getAlimento() != null
                        ? donacion.getAlimento().getId()
                        : null;

                String alimentoNombre = donacion.getAlimento() != null
                        ? donacion.getAlimento().getNombre()
                        : null;

                return new DonacionDTO(
                        donacion.getId(),
                        donacion.getCantidad(),
                        donacion.getFecha(),
                        usuarioId,
                        usuarioNombre,
                        alimentoId,
                        alimentoNombre
                );

            })
            .collect(Collectors.toList());
}

    public DonacionDTO buscarPorId(Long id) {

    Donacion donacion = donacionRepository.findById(id).orElse(null);

    if (donacion == null) {
        return null;
    }

    Long usuarioId = donacion.getUsuario() != null
            ? donacion.getUsuario().getId()
            : null;

    String usuarioNombre = donacion.getUsuario() != null
            ? donacion.getUsuario().getNombre()
            : null;

    Long alimentoId = donacion.getAlimento() != null
            ? donacion.getAlimento().getId()
            : null;

    String alimentoNombre = donacion.getAlimento() != null
            ? donacion.getAlimento().getNombre()
            : null;

    return new DonacionDTO(
            donacion.getId(),
            donacion.getCantidad(),
            donacion.getFecha(),
            usuarioId,
            usuarioNombre,
            alimentoId,
            alimentoNombre
    );
}

    public Donacion guardarDonacion(Donacion donacion) {
        Long usuarioId = donacion.getUsuario().getId();
        Long alimentoId = donacion.getAlimento().getId();

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Alimento alimento = alimentoRepository.findById(alimentoId)
                .orElseThrow(() -> new RuntimeException("Alimento no encontrado"));

        donacion.setUsuario(usuario);
        donacion.setAlimento(alimento);
        donacion.setFecha(LocalDate.now());

        return donacionRepository.save(donacion);
    }

    public void eliminarDonacion(Long id) {
        donacionRepository.deleteById(id);
    }

    public Donacion actualizarDonacion(Long id, Donacion donacionActualizada) {

    Donacion donacion = donacionRepository.findById(id).orElse(null);

    if (donacion == null) {
        return null;
    }

    Usuario usuario = usuarioRepository.findById(
            donacionActualizada.getUsuario().getId())
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

    Alimento alimento = alimentoRepository.findById(
            donacionActualizada.getAlimento().getId())
            .orElseThrow(() -> new RuntimeException("Alimento no encontrado"));

    donacion.setCantidad(donacionActualizada.getCantidad());
    donacion.setUsuario(usuario);
    donacion.setAlimento(alimento);

    return donacionRepository.save(donacion);
}
public List<Integer> obtenerDonacionesPorMes() {

    List<Integer> meses = new ArrayList<>();

    for (int i = 0; i < 12; i++) {
        meses.add(0);
    }

    List<Donacion> donaciones = donacionRepository.findAll();

    for (Donacion donacion : donaciones) {

        int mes = donacion.getFecha().getMonthValue();

        meses.set(
            mes - 1,
            meses.get(mes - 1) + 1
        );

    }

    return meses;

}
}  