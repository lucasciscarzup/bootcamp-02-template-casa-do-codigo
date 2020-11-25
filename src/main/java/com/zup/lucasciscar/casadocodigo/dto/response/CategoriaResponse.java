package com.zup.lucasciscar.casadocodigo.dto.response;

import com.zup.lucasciscar.casadocodigo.entity.Categoria;

public class CategoriaResponse {

    private String nome;

    public CategoriaResponse(Categoria categoria) {
        nome = categoria.getNome();
    }

    public String getNome() {
        return nome;
    }
}
