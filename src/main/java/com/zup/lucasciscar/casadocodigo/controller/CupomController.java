package com.zup.lucasciscar.casadocodigo.controller;

import com.zup.lucasciscar.casadocodigo.dto.request.CupomRequest;
import com.zup.lucasciscar.casadocodigo.dto.response.CupomResponse;
import com.zup.lucasciscar.casadocodigo.entity.Cupom;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class CupomController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/cupons")
    @Transactional
    public ResponseEntity<?> criarCupom(@RequestBody @Valid CupomRequest cupomRequest) {
        Cupom cupom = cupomRequest.toModel();
        entityManager.persist(cupom);

        CupomResponse cupomResponse = new CupomResponse(cupom);
        return ResponseEntity.ok(cupomResponse);
    }

}
