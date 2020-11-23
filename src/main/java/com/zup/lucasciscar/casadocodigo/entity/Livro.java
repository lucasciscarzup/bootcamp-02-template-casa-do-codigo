package com.zup.lucasciscar.casadocodigo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    @NotBlank
    private String sumario;

    @NotNull
    @Min(20)
    private BigDecimal preco;

    @NotNull
    @Min(100)
    private int numPaginas;

    @NotBlank
    @Column(unique = true)
    private String isbn;

    @NotNull
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @NotNull
    @Valid
    @ManyToOne
    private Categoria categoria;

    @NotNull
    @Valid
    @ManyToOne
    private Autor autor;

    @Deprecated
    public Livro() {

    }

    public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario, @NotNull @Min(20) BigDecimal preco,
                 @NotNull @Min(100) int numPaginas, @NotBlank String isbn, @NotNull @Future LocalDate dataPublicacao, @NotNull @Valid Categoria categoria,
                 @NotNull @Valid Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numPaginas = numPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }
    
}