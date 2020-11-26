package com.zup.lucasciscar.casadocodigo.localidade;

import com.zup.lucasciscar.casadocodigo.compartilhado.validator.ExistsObject;
import com.zup.lucasciscar.casadocodigo.compartilhado.validator.UniqueValue;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadoRequest {

    @NotBlank
    @UniqueValue(domainClass = Estado.class, fieldName = "nome")
    private String nome;

    @NotNull
    @ExistsObject(domainClass = Pais.class, fieldName = "id")
    private Long idPais;

    public EstadoRequest(@NotBlank String nome, @NotNull Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }

    public Estado toModel(EntityManager entityManager) {
        Pais pais = entityManager.find(Pais.class, idPais);

        return new Estado(nome, pais);
    }

}
