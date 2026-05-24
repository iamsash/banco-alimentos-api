package com.bancodealimentos26.donaciones26.repository;


import com.bancodealimentos26.donaciones26.model.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {
}
