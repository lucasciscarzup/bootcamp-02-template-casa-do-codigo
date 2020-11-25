package com.zup.lucasciscar.casadocodigo.dto.response;

import com.zup.lucasciscar.casadocodigo.entity.Autor;

public class AutorResponse {

    private String nome;
    private String email;
    private String descricao;

    public AutorResponse(Autor autor) {
        nome = autor.getNome();
        email = autor.getEmail();
        descricao = autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }
}
