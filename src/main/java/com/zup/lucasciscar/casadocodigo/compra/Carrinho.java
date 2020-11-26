package com.zup.lucasciscar.casadocodigo.compra;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "carrinhos")
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Valid
    @OneToOne
    private Compra compra;

    @NotNull
    @Positive
    private BigDecimal total;

    @Size(min = 1)
    @ElementCollection
    private Set<ItemCarrinho> itensCarrinho = new HashSet<>();

    @Deprecated
    public Carrinho() {

    }

    public Carrinho(@NotNull @Valid Compra compra, @NotNull @Positive BigDecimal total,
                    @Size(min = 1) Set<ItemCarrinho> itensCarrinho) {
        this.compra = compra;
        this.total = total;
        this.itensCarrinho.addAll(itensCarrinho);
    }

    public boolean totalIgual(BigDecimal total) {
        BigDecimal totalCarrinho = itensCarrinho.stream().map(ItemCarrinho :: precoTotal).reduce(BigDecimal.ZERO, (atual, prox) -> atual.add(prox));

        return totalCarrinho.doubleValue() == total.doubleValue();
    }

    public BigDecimal getTotal() {
        return total;
    }

    public Set<ItemCarrinho> getItensCarrinho() {
        return itensCarrinho;
    }
}
