package com.bancodealimentos26.donaciones26.service;

import com.bancodealimentos26.donaciones26.model.Alimento;
import com.bancodealimentos26.donaciones26.model.Donacion;
import com.bancodealimentos26.donaciones26.model.Usuario;
import com.bancodealimentos26.donaciones26.repository.AlimentoRepository;
import com.bancodealimentos26.donaciones26.repository.DonacionRepository;
import com.bancodealimentos26.donaciones26.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonacionService {

    @Autowired
    private DonacionRepository donacionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AlimentoRepository alimentoRepository;

    public List<Donacion> listarDonaciones() {
        return donacionRepository.findAll();
    }

    public Optional<Donacion> buscarPorId(Long id) {
        return donacionRepository.findById(id);
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

        return donacionRepository.save(donacion);
    }

    public void eliminarDonacion(Long id) {
        donacionRepository.deleteById(id);
    }
}