package com.rocketseat.desafio.junior.repository;

import com.rocketseat.desafio.junior.domain.entity.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {
}
