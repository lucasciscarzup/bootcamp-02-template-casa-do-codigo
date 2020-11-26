package com.zup.lucasciscar.casadocodigo.localidade;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class EstadoController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/estados")
    @Transactional
    public ResponseEntity<?> criarEstado(@RequestBody @Valid EstadoRequest estadoRequest) {
        Estado estado = estadoRequest.toModel(entityManager);
        entityManager.persist(estado);

        EstadoResponse estadoResponse = new EstadoResponse(estado);
        return ResponseEntity.ok(estadoResponse);
    }

}
