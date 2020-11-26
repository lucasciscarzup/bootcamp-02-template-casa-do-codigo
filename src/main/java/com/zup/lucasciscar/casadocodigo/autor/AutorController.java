package com.zup.lucasciscar.casadocodigo.autor;

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

    @PostMapping("/autores")
    @Transactional
    public ResponseEntity<?> criarAutor(@RequestBody @Valid AutorRequest autorRequest) {
        Autor autor = autorRequest.toModel();
        entityManager.persist(autor);

        AutorResponse autorResponse = new AutorResponse(autor);
        return ResponseEntity.ok(autorResponse);
    }

}
