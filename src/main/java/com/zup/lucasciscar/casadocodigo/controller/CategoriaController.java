package com.zup.lucasciscar.casadocodigo.controller;

import com.zup.lucasciscar.casadocodigo.dto.request.CategoriaRequest;
import com.zup.lucasciscar.casadocodigo.entity.Categoria;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class CategoriaController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/categoria")
    @Transactional
    public ResponseEntity<?> criarCategoria(@RequestBody @Valid CategoriaRequest categoriaRequest) {
        Categoria categoria = categoriaRequest.toModel();
        entityManager.persist(categoria);

        return ResponseEntity.ok(categoria.fromModel());
    }

}
