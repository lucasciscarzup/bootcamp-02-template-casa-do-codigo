package com.zup.lucasciscar.casadocodigo.controller;

import com.zup.lucasciscar.casadocodigo.dto.response.LivroDetalheResponse;
import com.zup.lucasciscar.casadocodigo.dto.response.LivroIdTituloResponse;
import com.zup.lucasciscar.casadocodigo.dto.request.LivroRequest;
import com.zup.lucasciscar.casadocodigo.entity.Livro;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LivroController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/livro")
    @Transactional
    public ResponseEntity<?> criarLivro(@RequestBody @Valid LivroRequest livroRequest) {
        Livro livro = livroRequest.toModel(entityManager);
        entityManager.persist(livro);

        return ResponseEntity.ok(livro.toString());
    }

    @GetMapping("/livros")
    @Transactional
    public ResponseEntity<?> buscarLivros() {
        List<Livro> livros = entityManager.createQuery("from Livro").getResultList();
        List<LivroIdTituloResponse> livrosResponse = livros.stream()
                .map(livro -> new LivroIdTituloResponse(livro)).collect(Collectors.toList());

        return ResponseEntity.ok(livrosResponse);
    }

    @GetMapping("/livros/{id}")
    @Transactional
    public ResponseEntity<?> detalharLivro(@PathVariable("id") Long idLivro) {
        Livro livro = entityManager.find(Livro.class, idLivro);
        if(livro == null)
            return ResponseEntity.notFound().build();

        LivroDetalheResponse livroDetalhe = new LivroDetalheResponse(livro);

        return ResponseEntity.ok(livroDetalhe);
    }

}
