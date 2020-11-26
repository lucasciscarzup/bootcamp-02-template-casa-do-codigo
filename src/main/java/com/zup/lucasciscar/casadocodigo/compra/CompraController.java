package com.zup.lucasciscar.casadocodigo.compra;

import com.zup.lucasciscar.casadocodigo.compartilhado.validator.CupomValidator;
import com.zup.lucasciscar.casadocodigo.compartilhado.validator.DocumentoValidator;
import com.zup.lucasciscar.casadocodigo.compartilhado.validator.EstadoPaisValidator;
import com.zup.lucasciscar.casadocodigo.compartilhado.validator.EstadoRequiredValidator;
import com.zup.lucasciscar.casadocodigo.cupom.CupomRepository;
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
    @Autowired
    private CupomValidator cupomValidator;
    @Autowired
    private CupomRepository cupomRepository;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(documentoValidator, estadoPaisValidator, estadoRequiredValidator, cupomValidator);
    }

    @PostMapping("/compras")
    @Transactional
    public ResponseEntity<?> fazerCompra(@RequestBody @Valid CompraRequest compraRequest, UriComponentsBuilder uriBuilder) {
        Compra compra = compraRequest.toModel(entityManager, cupomRepository);
        entityManager.persist(compra);

        URI uriLocation = uriBuilder.path("/compras/{id}").buildAndExpand(compra.getId()).toUri();

        return ResponseEntity.created(uriLocation).build();
    }

}
