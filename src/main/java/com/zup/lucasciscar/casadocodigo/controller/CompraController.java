package com.zup.lucasciscar.casadocodigo.controller;

import com.zup.lucasciscar.casadocodigo.dto.request.CompraRequest;
import com.zup.lucasciscar.casadocodigo.entity.Compra;
import com.zup.lucasciscar.casadocodigo.validator.DocumentoValidator;
import com.zup.lucasciscar.casadocodigo.validator.EstadoPaisValidator;
import com.zup.lucasciscar.casadocodigo.validator.EstadoRequiredValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class CompraController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private DocumentoValidator documentoValidator;
    @Autowired
    private EstadoPaisValidator estadoPaisValidator;
    @Autowired
    private EstadoRequiredValidator estadoRequiredValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(documentoValidator, estadoPaisValidator, estadoRequiredValidator);
    }

    @PostMapping("/compra")
    @Transactional
    public ResponseEntity<?> fazerCompra(@RequestBody @Valid CompraRequest compraRequest) {
        Compra compra = compraRequest.toModel(entityManager);
        entityManager.persist(compra);

        return ResponseEntity.ok(compra.toString());
    }

}