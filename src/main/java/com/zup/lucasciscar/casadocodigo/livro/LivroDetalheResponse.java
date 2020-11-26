package com.zup.lucasciscar.casadocodigo.livro;

import com.zup.lucasciscar.casadocodigo.autor.AutorResponse;
import com.zup.lucasciscar.casadocodigo.autor.Autor;
import com.zup.lucasciscar.casadocodigo.categoria.CategoriaResponse;
import com.zup.lucasciscar.casadocodigo.categoria.Categoria;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LivroDetalheResponse {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private int numPaginas;
    private String isbn;
    private String dataPublicacao;
    private CategoriaResponse categoria;
    private AutorResponse autor;

    public LivroDetalheResponse(String titulo, String resumo, String sumario, BigDecimal preco, int numPaginas, String isbn,
                                LocalDate dataPublicacao, Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numPaginas = numPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.categoria = new CategoriaResponse(categoria);
        this.autor = new AutorResponse(autor);
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

    public String getDataPublicacao() {
        return dataPublicacao;
    }

    public CategoriaResponse getCategoria() {
        return categoria;
    }

    public AutorResponse getAutor() {
        return autor;
    }
}
