package com.zup.lucasciscar.casadocodigo.compra;

import com.zup.lucasciscar.casadocodigo.livro.Livro;
import com.zup.lucasciscar.casadocodigo.compartilhado.validator.ExistsObject;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ItemCarrinhoRequest {

    @NotNull
    @ExistsObject(domainClass = Livro.class, fieldName = "id")
    private Long idLivro;

    @Positive
    private int quantidade;

    public ItemCarrinhoRequest(@NotNull Long idLivro, @Positive int quantidade) {
        this.idLivro = idLivro;
        this.quantidade = quantidade;
    }

    public Long getIdLivro() {
        return idLivro;
    }

    public ItemCarrinho toModel(EntityManager entityManager) {
        Livro livro = entityManager.find(Livro.class, idLivro);

        return new ItemCarrinho(livro, quantidade);
    }

}
