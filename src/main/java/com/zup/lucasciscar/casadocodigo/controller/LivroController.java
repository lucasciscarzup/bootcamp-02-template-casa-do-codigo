package com.zup.lucasciscar.casadocodigo.controller;

import com.zup.lucasciscar.casadocodigo.dto.LivroRequest;
import com.zup.lucasciscar.casadocodigo.entity.Livro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
public class LivroController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/livro")
    @Transactional
    public ResponseEntity<?> criarLivro(@RequestBody @Valid LivroRequest livroRequest) {
        Livro livro = livroRequest.toModel(entityManager);
        entityManager.persist(livro);

        return ResponseEntity.ok(livro);
    }

    @GetMapping("/livros")
    @Transactional
    public List<Livro> buscarLivros() {
        return entityManager.createQuery("select id, titulo from Livro").getResultList();
    }

}
