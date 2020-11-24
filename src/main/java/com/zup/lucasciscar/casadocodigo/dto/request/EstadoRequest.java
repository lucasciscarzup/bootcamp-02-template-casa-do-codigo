package com.zup.lucasciscar.casadocodigo.dto.request;

import com.zup.lucasciscar.casadocodigo.entity.Estado;
import com.zup.lucasciscar.casadocodigo.entity.Pais;
import com.zup.lucasciscar.casadocodigo.validator.ExistsId;
import com.zup.lucasciscar.casadocodigo.validator.UniqueValue;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadoRequest {

    @NotBlank
    @UniqueValue(domainClass = Estado.class, fieldName = "nome")
    private String nome;

    @NotNull
    @ExistsId(domainClass = Pais.class)
    private Long idPais;

    public EstadoRequest(@NotBlank String nome, @NotNull Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }

    public Estado toModel(EntityManager entityManager) {
        Pais pais = entityManager.find(Pais.class, idPais);
        Assert.state(pais != null, "País não existe no sistema");

        return new Estado(nome, pais);
    }

}
