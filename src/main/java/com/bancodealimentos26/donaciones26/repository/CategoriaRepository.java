package com.bancodealimentos26.donaciones26.repository;

import com.bancodealimentos26.donaciones26.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}