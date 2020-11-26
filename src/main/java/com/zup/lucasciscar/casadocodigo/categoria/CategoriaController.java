package com.zup.lucasciscar.casadocodigo.categoria;

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

    @PostMapping("/categorias")
    @Transactional
    public ResponseEntity<?> criarCategoria(@RequestBody @Valid CategoriaRequest categoriaRequest) {
        Categoria categoria = categoriaRequest.toModel();
        entityManager.persist(categoria);

        CategoriaResponse categoriaResponse = new CategoriaResponse(categoria);
        return ResponseEntity.ok(categoriaResponse);
    }

}
