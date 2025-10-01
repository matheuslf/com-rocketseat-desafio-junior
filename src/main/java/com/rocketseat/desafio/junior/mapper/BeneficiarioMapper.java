package com.rocketseat.desafio.junior.mapper;

import com.rocketseat.desafio.junior.domain.dto.BeneficiarioRequest;
import com.rocketseat.desafio.junior.domain.dto.BeneficiarioResponse;
import com.rocketseat.desafio.junior.domain.dto.DocumentoDTO;
import com.rocketseat.desafio.junior.domain.entity.Beneficiario;
import com.rocketseat.desafio.junior.domain.entity.Documento;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BeneficiarioMapper {

    public Beneficiario toEntity(BeneficiarioRequest req) {
        Beneficiario b = new Beneficiario();
        b.setNome(req.nome());
        b.setDataNascimento(req.dataNascimento());
        List<Documento> docs = req.documentos().stream().map(d -> {
            Documento doc = new Documento();
            doc.setTipo(d.tipo());
            doc.setNumero(d.numero());
            doc.setBeneficiario(b);
            return doc;
        }).toList();
        b.setDocumentos(docs);
        return b;
    }

    public BeneficiarioResponse toResponse(Beneficiario b) {
        List<DocumentoDTO> docs = b.getDocumentos().stream().map(d -> new DocumentoDTO(d.getTipo(), d.getNumero())).toList();
        return new BeneficiarioResponse(b.getId(), b.getNome(), b.getDataNascimento(), docs);
    }

}
