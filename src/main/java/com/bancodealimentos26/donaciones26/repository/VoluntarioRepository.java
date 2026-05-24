package com.bancodealimentos26.donaciones26.repository;

import com.bancodealimentos26.donaciones26.model.Voluntario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoluntarioRepository extends JpaRepository<Voluntario, Long> {
}
