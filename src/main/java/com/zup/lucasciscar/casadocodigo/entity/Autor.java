package com.zup.lucasciscar.casadocodigo.entity;

import com.sun.istack.NotNull;
import com.zup.lucasciscar.casadocodigo.dto.response.AutorResponse;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    @Size(max = 400)
    private String descricao;

    @NotNull
    @PastOrPresent
    @CreationTimestamp
    private LocalDateTime criadoEm;

    @Deprecated
    public Autor() {

    }

    public Autor(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public AutorResponse fromModel() {
        return new AutorResponse(nome, email, descricao);
    }
}
