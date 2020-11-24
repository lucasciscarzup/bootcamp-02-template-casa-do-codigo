package com.zup.lucasciscar.casadocodigo.dto.response;

import com.zup.lucasciscar.casadocodigo.entity.Livro;

public class LivroIdTituloResponse {

    private long id;
    private String titulo;

    public LivroIdTituloResponse(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

}
