package com.zup.lucasciscar.casadocodigo.dto.request;

import com.zup.lucasciscar.casadocodigo.entity.Categoria;
import com.zup.lucasciscar.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public Categoria toModel() {
        return new Categoria(nome);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
