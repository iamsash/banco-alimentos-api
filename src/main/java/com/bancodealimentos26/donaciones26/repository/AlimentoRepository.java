package com.bancodealimentos26.donaciones26.repository;

import com.bancodealimentos26.donaciones26.model.Alimento;
//trae metodos listos para usar 
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlimentoRepository extends JpaRepository<Alimento, Long> {
}

//Este repository permite realizar operaciones CRUD 
// sobre la entidad Alimento usando JPA sin necesidad de escribir consultas SQL.”