package com.zup.lucasciscar.casadocodigo.localidade;

import com.zup.lucasciscar.casadocodigo.compartilhado.validator.UniqueValue;

import javax.validation.constraints.NotBlank;

public class PaisRequest {

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    public Pais toModel() {
        return new Pais(nome);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
