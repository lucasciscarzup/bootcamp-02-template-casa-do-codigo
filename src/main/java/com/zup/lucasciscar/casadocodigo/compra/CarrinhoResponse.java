package com.zup.lucasciscar.casadocodigo.compra;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

public class CarrinhoResponse {

    private BigDecimal total;
    private List<ItemCarrinhoResponse> itens;
    private BigDecimal totalComDesconto;

    public CarrinhoResponse(Carrinho carrinho) {
        this.total = carrinho.getTotal();
        this.itens = carrinho.getItensCarrinho().stream()
                .map(item -> new ItemCarrinhoResponse(item)).collect(Collectors.toList());
    }

    public void descontaValorCupom(BigDecimal valorCupom) {
        this.totalComDesconto = total.subtract(total.multiply(
                valorCupom.divide(new BigDecimal(100))
        )).setScale(2, RoundingMode.CEILING);
    }

    public BigDecimal getTotal() {
        return total;
    }

    public List<ItemCarrinhoResponse> getItens() {
        return itens;
    }

    public BigDecimal getTotalComDesconto() {
        return totalComDesconto;
    }
}
