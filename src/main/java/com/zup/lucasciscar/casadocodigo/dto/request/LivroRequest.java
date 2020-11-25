package com.zup.lucasciscar.casadocodigo.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zup.lucasciscar.casadocodigo.entity.Autor;
import com.zup.lucasciscar.casadocodigo.entity.Categoria;
import com.zup.lucasciscar.casadocodigo.entity.Livro;
import com.zup.lucasciscar.casadocodigo.validator.ExistsId;
import com.zup.lucasciscar.casadocodigo.validator.UniqueValue;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroRequest {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
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
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;

    @NotNull
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @NotNull
    @ExistsId(domainClass = Categoria.class)
    private Long idCategoria;

    @NotNull
    @ExistsId(domainClass = Autor.class)
    private Long idAutor;

    public LivroRequest(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario, @NotNull @Min(20) BigDecimal preco,
                        @NotNull @Min(100) int numPaginas, @NotBlank String isbn, @NotNull Long idCategoria, @NotNull Long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numPaginas = numPaginas;
        this.isbn = isbn;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }

    public Livro toModel(EntityManager entityManager) {
        Categoria categoria = entityManager.find(Categoria.class, idCategoria);
        Autor autor = entityManager.find(Autor.class, idAutor);

        return new Livro(titulo, resumo, sumario, preco, numPaginas, isbn, dataPublicacao, categoria, autor);
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

}
