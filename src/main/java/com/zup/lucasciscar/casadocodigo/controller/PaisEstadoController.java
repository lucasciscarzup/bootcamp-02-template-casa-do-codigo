package com.zup.lucasciscar.casadocodigo.controller;

import com.zup.lucasciscar.casadocodigo.dto.request.EstadoRequest;
import com.zup.lucasciscar.casadocodigo.dto.request.PaisRequest;
import com.zup.lucasciscar.casadocodigo.entity.Estado;
import com.zup.lucasciscar.casadocodigo.entity.Pais;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class PaisEstadoController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/pais")
    @Transactional
    public ResponseEntity<?> criarPais(@RequestBody @Valid PaisRequest paisRequest) {
        Pais pais = paisRequest.toModel();
        entityManager.persist(pais);

        return ResponseEntity.ok(pais.toString());
    }

    @PostMapping("/estado")
    @Transactional
    public ResponseEntity<?> criarEstado(@RequestBody @Valid EstadoRequest estadoRequest) {
        Estado estado = estadoRequest.toModel(entityManager);
        entityManager.persist(estado);

        return ResponseEntity.ok(estado.toString());
    }

}
