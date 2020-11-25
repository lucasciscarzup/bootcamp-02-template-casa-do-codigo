package com.zup.lucasciscar.casadocodigo.dto.response;

import com.zup.lucasciscar.casadocodigo.entity.Pais;

public class PaisResponse {

    private String nome;

    public PaisResponse(Pais pais) {
        nome = pais.getNome();
    }

    public String getNome() {
        return nome;
    }
}
