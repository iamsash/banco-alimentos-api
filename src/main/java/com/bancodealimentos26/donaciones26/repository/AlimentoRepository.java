package com.bancodealimentos26.donaciones26.repository;

import com.bancodealimentos26.donaciones26.model.Alimento;
//trae metodos listos para usar 
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AlimentoRepository extends JpaRepository<Alimento, Long> {

    List<Alimento> findByNombreProducto(String nombreProducto);

    List<Alimento> findByCategoria(String categoria);

    List<Alimento> findByNombreProductoContaining(String nombre);
}

//Este repository permite realizar operaciones CRUD 
// sobre la entidad Alimento usando JPA sin necesidad de escribir consultas SQL.”