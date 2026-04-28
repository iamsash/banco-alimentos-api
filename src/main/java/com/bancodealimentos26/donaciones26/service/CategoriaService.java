package com.bancodealimentos26.donaciones26.service;

import com.bancodealimentos26.donaciones26.model.Categoria;
import com.bancodealimentos26.donaciones26.repository.CategoriaRepository;  
import org. springframework.stereotype.Service;
import java.util.List;

import java.util.Optional;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;

    }
    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

  public Optional<Categoria> obtenerPorId(Long id) {
        return categoriaRepository.findById(id);
    }


    public Categoria guardarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

   
   public Categoria actualizarCategoria(Long id, Categoria categoriaActualizada) {
        return categoriaRepository.findById(id).map(categoria -> {
            categoria.setNombre(categoriaActualizada.getNombre());
            categoria.setDescripcion(categoriaActualizada.getDescripcion());
            categoria.setFechaRegistro(categoriaActualizada.getFechaRegistro());
            return categoriaRepository.save(categoria);
        }).orElse(null);
    }

    public boolean eliminarCategoria(Long id) {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

    
