package com.zup.lucasciscar.casadocodigo.compra;

import com.zup.lucasciscar.casadocodigo.livro.Livro;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.Objects;

@Embeddable
public class ItemCarrinho {

    @NotNull
    @ManyToOne
    private Livro livro;

    @Positive
    private int quantidade;

    @Positive
    private BigDecimal precoCompra;

    @Deprecated
    public ItemCarrinho() {

    }

    public ItemCarrinho(@NotNull Livro livro, @Positive int quantidade) {
        this.livro = livro;
        this.quantidade = quantidade;
        this.precoCompra = livro.getPreco();
    }

    public BigDecimal precoTotal() {
        return precoCompra.multiply(new BigDecimal(quantidade));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemCarrinho that = (ItemCarrinho) o;
        return Objects.equals(livro, that.livro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(livro);
    }

    public Livro getLivro() {
        return livro;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
