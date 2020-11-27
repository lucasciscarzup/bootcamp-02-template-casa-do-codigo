package com.zup.lucasciscar.casadocodigo.livro;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zup.lucasciscar.casadocodigo.autor.Autor;
import com.zup.lucasciscar.casadocodigo.categoria.Categoria;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

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

    public Livro(LivroBuilder livroBuilder) {
        this.titulo = livroBuilder.getTitulo();
        this.resumo = livroBuilder.getResumo();
        this.sumario = livroBuilder.getSumario();
        this.preco = livroBuilder.getPreco();
        this.numPaginas = livroBuilder.getNumPaginas();
        this.isbn = livroBuilder.getIsbn();
        this.dataPublicacao = livroBuilder.getDataPublicacao();
        this.categoria = livroBuilder.getCategoria();
        this.autor = livroBuilder.getAutor();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(isbn, livro.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}
