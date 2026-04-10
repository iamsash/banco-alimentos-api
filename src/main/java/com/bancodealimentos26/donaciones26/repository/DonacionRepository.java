package com.bancodealimentos26.donaciones26.repository;

import com.bancodealimentos26.donaciones26.model.Donacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonacionRepository extends JpaRepository<Donacion, Long> {
}