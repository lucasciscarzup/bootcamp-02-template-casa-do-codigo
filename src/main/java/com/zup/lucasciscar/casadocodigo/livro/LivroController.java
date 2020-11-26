package com.zup.lucasciscar.casadocodigo.livro;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
public class LivroController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/livros")
    @Transactional
    public ResponseEntity<?> criarLivro(@RequestBody @Valid LivroRequest livroRequest) {
        Livro livro = livroRequest.toModel(entityManager);
        entityManager.persist(livro);

        LivroResponse livroResponse = new LivroResponse(livro);
        return ResponseEntity.ok(livroResponse);
    }

    @GetMapping("/livros")
    @Transactional
    public ResponseEntity<?> buscarLivros() {
        List<LivroIdTituloResponse> livros = entityManager.createQuery(
                " select new com.zup.lucasciscar.casadocodigo.livro.LivroIdTituloResponse(id, titulo)" +
                        " from Livro" +
                        " order by id", LivroIdTituloResponse.class
        ).getResultList();

        return ResponseEntity.ok(livros);
    }

    @GetMapping("/livros/{id}")
    @Transactional
    public ResponseEntity<?> detalharLivro(@PathVariable("id") Long idLivro) {
        Livro livro = entityManager.find(Livro.class, idLivro);
        if(livro == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado");

        LivroDetalheResponse livroDetalheResponse = entityManager.createQuery(
                " select new com.zup.lucasciscar.casadocodigo.livro.LivroDetalheResponse(" +
                        " l.titulo, l.resumo, l.sumario, l.preco, l.numPaginas," +
                        " l.isbn, l.dataPublicacao, l.categoria, l.autor" +
                        " ) " +
                        " from Livro l" +
                        " where l.id = :value", LivroDetalheResponse.class
        ).setParameter("value", idLivro).getSingleResult();

        return ResponseEntity.ok(livroDetalheResponse);
    }

}
