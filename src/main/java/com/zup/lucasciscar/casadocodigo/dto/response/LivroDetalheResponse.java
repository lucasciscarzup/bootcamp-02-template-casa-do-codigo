package com.zup.lucasciscar.casadocodigo.dto.response;

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
    private String nomeAutor;
    private String descricaoAutor;

    public LivroDetalheResponse(String titulo, String resumo, String sumario, BigDecimal preco, int numPaginas,
                                String isbn, LocalDate dataPublicacao, String nomeAutor, String descricaoAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numPaginas = numPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.nomeAutor = nomeAutor;
        this.descricaoAutor = descricaoAutor;
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

    public String getNomeAutor() {
        return nomeAutor;
    }

    public String getDescricaoAutor() {
        return descricaoAutor;
    }
}
