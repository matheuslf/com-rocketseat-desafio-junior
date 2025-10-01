package com.rocketseat.desafio.junior.domain.dto;

import java.time.LocalDate;
import java.util.List;

public record BeneficiarioResponse(Long id, String nome, LocalDate dataNascimento, List<DocumentoDTO> documentos) {
}
