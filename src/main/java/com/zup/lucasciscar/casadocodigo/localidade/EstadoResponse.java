package com.zup.lucasciscar.casadocodigo.localidade;

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
