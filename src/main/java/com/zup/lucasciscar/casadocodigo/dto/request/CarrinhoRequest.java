package com.zup.lucasciscar.casadocodigo.dto.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoRequest {

    @NotNull
    @Positive
    private BigDecimal total;

    @Valid
    @Size(min = 1)
    private List<ItemCarrinhoRequest> itens = new ArrayList<>();

    public CarrinhoRequest(@NotNull @Positive BigDecimal total, List<ItemCarrinhoRequest> itens) {
        this.total = total;
        this.itens = itens;
    }

    public List<ItemCarrinhoRequest> getItens() {
        return itens;
    }

}
