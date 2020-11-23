package com.zup.lucasciscar.casadocodigo.dto.response;

public class AutorResponse {

    private String nome;
    private String email;
    private String descricao;

    public AutorResponse(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
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
