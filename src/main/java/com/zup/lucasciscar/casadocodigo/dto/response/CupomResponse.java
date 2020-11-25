package com.zup.lucasciscar.casadocodigo.dto.response;

import com.zup.lucasciscar.casadocodigo.entity.Cupom;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class CupomResponse {

    private String codigo;
    private BigDecimal desconto;
    private String validade;

    public CupomResponse(Cupom cupom) {
        codigo = cupom.getCodigo();
        desconto = cupom.getDesconto();
        validade = cupom.getValidade().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public String getCodigo() {
        return codigo;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public String getValidade() {
        return validade;
    }
}
