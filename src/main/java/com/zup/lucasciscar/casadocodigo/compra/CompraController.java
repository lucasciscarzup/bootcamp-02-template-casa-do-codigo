package com.zup.lucasciscar.casadocodigo.compra;

import com.zup.lucasciscar.casadocodigo.compartilhado.validator.DocumentoValidator;
import com.zup.lucasciscar.casadocodigo.compartilhado.validator.EstadoPaisValidator;
import com.zup.lucasciscar.casadocodigo.compartilhado.validator.EstadoRequiredValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

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

    @PostMapping("/compras")
    @Transactional
    public ResponseEntity<?> fazerCompra(@RequestBody @Valid CompraRequest compraRequest, UriComponentsBuilder uriBuilder) {
        Compra compra = compraRequest.toModel(entityManager);
        entityManager.persist(compra);

        URI uriLocation = uriBuilder.path("/compras/{id}").buildAndExpand(compra.getId()).toUri();

        return ResponseEntity.created(uriLocation).build();
    }

}
