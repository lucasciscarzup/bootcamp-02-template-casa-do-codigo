package com.zup.lucasciscar.casadocodigo.dto.response;

public class LivroIdTituloResponse {

    private Long id;
    private String titulo;

    public LivroIdTituloResponse(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

}
