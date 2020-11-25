package com.zup.lucasciscar.casadocodigo.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zup.lucasciscar.casadocodigo.entity.Cupom;
import com.zup.lucasciscar.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

public class CupomRequest {

    @NotBlank
    @UniqueValue(domainClass = Cupom.class, fieldName = "codigo")
    private String codigo;

    @NotNull
    @Positive
    private BigDecimal desconto;

    @NotNull
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate validade;

    public CupomRequest(@NotBlank String codigo, @NotNull @Positive BigDecimal desconto) {
        this.codigo = codigo;
        this.desconto = desconto;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public Cupom toModel() {
        return new Cupom(codigo, desconto, validade);
    }
}
