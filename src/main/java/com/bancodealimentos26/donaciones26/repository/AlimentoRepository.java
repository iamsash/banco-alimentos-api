package com.bancodealimentos26.donaciones26.repository;

import com.bancodealimentos26.donaciones26.model.Alimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlimentoRepository extends JpaRepository<Alimento, Long> {
}