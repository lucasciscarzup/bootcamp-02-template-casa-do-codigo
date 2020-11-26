package com.zup.lucasciscar.casadocodigo.cupom;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Embeddable
public class CupomAplicado {

    @ManyToOne
    private Cupom cupom;

    @NotNull
    @Positive
    private BigDecimal descontoCompra;

    @NotNull
    @Future
    private LocalDate validadeCompra;

    @Deprecated
    public CupomAplicado() {

    }

    public CupomAplicado(Cupom cupom) {
        this.cupom = cupom;
        this.descontoCompra = cupom.getDesconto();
        this.validadeCompra = cupom.getValidade();
    }

    public BigDecimal getDescontoCompra() {
        return descontoCompra;
    }
}
