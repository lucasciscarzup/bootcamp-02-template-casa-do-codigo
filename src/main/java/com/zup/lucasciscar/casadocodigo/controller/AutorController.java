package com.zup.lucasciscar.casadocodigo.controller;

import com.zup.lucasciscar.casadocodigo.dto.request.AutorRequest;
import com.zup.lucasciscar.casadocodigo.entity.Autor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class AutorController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/autor")
    @Transactional
    public ResponseEntity<?> criarAutor(@RequestBody @Valid AutorRequest autorRequest) {
        Autor autor = autorRequest.toModel();
        entityManager.persist(autor);

        return ResponseEntity.ok(autor.toString());
    }

}
