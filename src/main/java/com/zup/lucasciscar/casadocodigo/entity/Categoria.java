package com.zup.lucasciscar.casadocodigo.entity;

import com.zup.lucasciscar.casadocodigo.dto.response.CategoriaResponse;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String nome;

    @Deprecated
    public Categoria() {

    }

    public Categoria(@NotBlank String nome) {
        this.nome = nome;
    }

    public CategoriaResponse fromModel() {
        return new CategoriaResponse(nome);
    }

}
