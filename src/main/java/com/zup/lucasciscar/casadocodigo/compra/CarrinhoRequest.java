package com.zup.lucasciscar.casadocodigo.compra;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CarrinhoRequest {

    @NotNull
    @Positive
    private BigDecimal total;

    @Valid
    @Size(min = 1)
    private List<ItemCarrinhoRequest> itens = new ArrayList<>();

    public CarrinhoRequest(@NotNull @Positive BigDecimal total, @Valid @Size(min = 1) List<ItemCarrinhoRequest> itens) {
        this.total = total;
        this.itens = itens;
    }

    public List<ItemCarrinhoRequest> getItens() {
        return itens;
    }

    public Function<Compra, Carrinho> toModel(EntityManager entityManager) {
        Set<ItemCarrinho> itensCarrinho = itens.stream().map(item -> item.toModel(entityManager)).collect(Collectors.toSet());

        return (compra) -> {
            Carrinho carrinho = new Carrinho(compra, itensCarrinho);
            Assert.isTrue(carrinho.totalIgual(total), "O total enviado não corresponde ao total do carrinho");

            return carrinho;
        };
    }

}
