package com.rocketseat.desafio.junior.repository;

import com.rocketseat.desafio.junior.domain.entity.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {
}
