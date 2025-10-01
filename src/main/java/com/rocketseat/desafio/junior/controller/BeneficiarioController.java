package com.rocketseat.desafio.junior.controller;

import com.rocketseat.desafio.junior.domain.dto.BeneficiarioRequest;
import com.rocketseat.desafio.junior.domain.dto.BeneficiarioResponse;
import com.rocketseat.desafio.junior.domain.dto.DocumentoDTO;
import com.rocketseat.desafio.junior.service.BeneficiarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beneficiarios")
public class BeneficiarioController {

    private final BeneficiarioService service;

    public BeneficiarioController(BeneficiarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<BeneficiarioResponse> criar(@RequestBody BeneficiarioRequest req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(req));
    }

    @GetMapping
    public List<BeneficiarioResponse> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}/documentos")
    public List<DocumentoDTO> listarDocumentos(@PathVariable Long id) {
        return service.listarDocumentos(id);
    }

    @PutMapping("/{id}")
    public BeneficiarioResponse atualizar(@PathVariable Long id, @RequestBody BeneficiarioRequest req) {
        return service.atualizar(id, req);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }
}
