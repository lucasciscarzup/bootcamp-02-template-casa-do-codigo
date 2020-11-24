package com.zup.lucasciscar.casadocodigo.controller;

import com.zup.lucasciscar.casadocodigo.dto.request.PagamentoRequest;
import com.zup.lucasciscar.casadocodigo.entity.Pagamento;
import com.zup.lucasciscar.casadocodigo.validator.DocumentoValidator;
import com.zup.lucasciscar.casadocodigo.validator.EstadoPaisValidator;
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
public class PagamentoController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private DocumentoValidator documentoValidator;
    @Autowired
    private EstadoPaisValidator estadoPaisValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(documentoValidator, estadoPaisValidator);
    }

    @PostMapping("/pagamento")
    @Transactional
    public ResponseEntity<?> fazerPagamento(@RequestBody @Valid PagamentoRequest pagamentoRequest) {
        Pagamento pagamento = pagamentoRequest.toModel(entityManager);
        entityManager.persist(pagamento);

        return ResponseEntity.ok(pagamento.toString());
    }

}
