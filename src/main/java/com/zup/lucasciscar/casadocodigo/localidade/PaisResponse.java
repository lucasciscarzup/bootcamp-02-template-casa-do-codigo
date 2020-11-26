package com.zup.lucasciscar.casadocodigo.localidade;

public class PaisResponse {

    private String nome;

    public PaisResponse(Pais pais) {
        nome = pais.getNome();
    }

    public String getNome() {
        return nome;
    }
}
