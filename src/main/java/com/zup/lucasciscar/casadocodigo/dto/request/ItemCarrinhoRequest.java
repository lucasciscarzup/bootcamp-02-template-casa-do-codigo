package com.zup.lucasciscar.casadocodigo.dto.request;

import com.zup.lucasciscar.casadocodigo.entity.ItemCarrinho;
import com.zup.lucasciscar.casadocodigo.entity.Livro;
import com.zup.lucasciscar.casadocodigo.validator.ExistsId;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ItemCarrinhoRequest {

    @NotNull
    @ExistsId(domainClass = Livro.class)
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
