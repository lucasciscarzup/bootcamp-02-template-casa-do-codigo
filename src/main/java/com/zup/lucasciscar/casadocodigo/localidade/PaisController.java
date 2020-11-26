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
public class PaisController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/paises")
    @Transactional
    public ResponseEntity<?> criarPais(@RequestBody @Valid PaisRequest paisRequest) {
        Pais pais = paisRequest.toModel();
        entityManager.persist(pais);

        PaisResponse paisResponse = new PaisResponse(pais);
        return ResponseEntity.ok(paisResponse);
    }

}
