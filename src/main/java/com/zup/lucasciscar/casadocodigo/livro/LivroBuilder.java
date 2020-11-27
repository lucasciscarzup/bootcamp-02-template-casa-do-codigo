package com.zup.lucasciscar.casadocodigo.livro;

import com.zup.lucasciscar.casadocodigo.autor.Autor;
import com.zup.lucasciscar.casadocodigo.categoria.Categoria;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroBuilder {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private int numPaginas;
    private String isbn;
    private LocalDate dataPublicacao;
    private Categoria categoria;
    private Autor autor;

    public LivroBuilder addTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public LivroBuilder addResumo(String resumo) {
        this.resumo = resumo;
        return this;
    }

    public LivroBuilder addSumario(String sumario) {
        this.sumario = sumario;
        return this;
    }

    public LivroBuilder addPreco(BigDecimal preco) {
        this.preco = preco;
        return this;
    }

    public LivroBuilder addNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
        return this;
    }

    public LivroBuilder addIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public LivroBuilder addDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
        return this;
    }

    public LivroBuilder addCategoria(Categoria categoria) {
        this.categoria = categoria;
        return this;
    }

    public LivroBuilder addAutor(Autor autor) {
        this.autor = autor;
        return this;
    }

    public Livro build() {
        return new Livro(this);
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
