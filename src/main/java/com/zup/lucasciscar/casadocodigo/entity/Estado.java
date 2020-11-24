package com.zup.lucasciscar.casadocodigo.entity;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "estados")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String nome;

    @NotNull
    @Valid
    @ManyToOne
    private Pais pais;

    public Estado(@NotBlank String nome, @NotNull @Valid Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", pais=" + pais +
                '}';
    }

}
