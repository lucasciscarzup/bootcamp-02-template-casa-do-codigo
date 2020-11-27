package com.zup.lucasciscar.casadocodigo.compra;

import com.zup.lucasciscar.casadocodigo.localidade.EstadoResponse;
import com.zup.lucasciscar.casadocodigo.localidade.PaisResponse;

import java.math.BigDecimal;

public class CompraDetalheResponse {

    private String email;
    private String nome;
    private String sobrenome;
    private String documento;
    private String endereco;
    private String complemento;
    private String cidade;
    private PaisResponse pais;
    private EstadoResponse estado;
    private String telefone;
    private String cep;
    private CarrinhoResponse carrinho;
    private boolean existeCupom;
    private BigDecimal valorCupom;

    public CompraDetalheResponse(Compra compra) {
        this.email = compra.getEmail();
        this.nome = compra.getNome();
        this.sobrenome = compra.getSobrenome();
        this.documento = compra.getDocumento();
        this.endereco = compra.getEndereco();
        this.complemento = compra.getComplemento();
        this.cidade = compra.getCidade();
        this.pais = new PaisResponse(compra.getPais());
        this.telefone = compra.getTelefone();
        this.cep = compra.getCep();
        this.carrinho = new CarrinhoResponse(compra.getCarrinho());

        if(compra.getEstado() != null)
            this.estado = new EstadoResponse(compra.getEstado());
        if(compra.getCupomAplicado() != null) {
            this.existeCupom = true;
            this.valorCupom = compra.getCupomAplicado().getDescontoCompra();
            carrinho.descontaValorCupom(valorCupom);
        }
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public PaisResponse getPais() {
        return pais;
    }

    public EstadoResponse getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public CarrinhoResponse getCarrinho() {
        return carrinho;
    }

    public boolean isExisteCupom() {
        return existeCupom;
    }

    public BigDecimal getValorCupom() {
        return valorCupom;
    }
}
