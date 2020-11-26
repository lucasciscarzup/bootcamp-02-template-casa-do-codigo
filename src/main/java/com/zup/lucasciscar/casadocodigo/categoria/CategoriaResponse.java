package com.zup.lucasciscar.casadocodigo.categoria;

public class CategoriaResponse {

    private String nome;

    public CategoriaResponse(Categoria categoria) {
        nome = categoria.getNome();
    }

    public String getNome() {
        return nome;
    }
}
