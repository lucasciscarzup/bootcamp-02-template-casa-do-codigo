package com.zup.lucasciscar.casadocodigo.dto.response;

import com.zup.lucasciscar.casadocodigo.entity.Estado;

public class EstadoResponse {

    private String nome;
    private PaisResponse pais;

    public EstadoResponse(Estado estado) {
        nome = estado.getNome();
        pais = new PaisResponse(estado.getPais());
    }

    public String getNome() {
        return nome;
    }

    public PaisResponse getPais() {
        return pais;
    }
}
