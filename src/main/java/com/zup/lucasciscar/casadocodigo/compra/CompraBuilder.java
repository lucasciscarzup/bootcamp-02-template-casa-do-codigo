package com.zup.lucasciscar.casadocodigo.compra;

import com.zup.lucasciscar.casadocodigo.cupom.Cupom;
import com.zup.lucasciscar.casadocodigo.cupom.CupomAplicado;
import com.zup.lucasciscar.casadocodigo.localidade.Estado;
import com.zup.lucasciscar.casadocodigo.localidade.Pais;

import java.util.function.Function;

public class CompraBuilder {

    private String email;
    private String nome;
    private String sobrenome;
    private String documento;
    private String endereco;
    private String complemento;
    private String cidade;
    private Pais pais;
    private Estado estado;
    private String telefone;
    private String cep;
    private Function<Compra, Carrinho> funcaoCriaCarrinho;
    private CupomAplicado cupomAplicado;

    public CompraBuilder addEmail(String email) {
        this.email = email;
        return this;
    }

    public CompraBuilder addNome(String nome) {
        this.nome = nome;
        return this;
    }

    public CompraBuilder addSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
        return this;
    }

    public CompraBuilder addDocumento(String documento) {
        this.documento = documento;
        return this;
    }

    public CompraBuilder addEndereco(String endereco) {
        this.endereco = endereco;
        return this;
    }

    public CompraBuilder addComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    public CompraBuilder addCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public CompraBuilder addPais(Pais pais) {
        this.pais = pais;
        return this;
    }

    public CompraBuilder addEstado(Estado estado) {
        this.estado = estado;
        return this;
    }

    public CompraBuilder addTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public CompraBuilder addCep(String cep) {
        this.cep = cep;
        return this;
    }

    public CompraBuilder addFuncaoCriaCarrinho(Function<Compra, Carrinho> funcaoCriaCarrinho) {
        this.funcaoCriaCarrinho = funcaoCriaCarrinho;
        return this;
    }

    public CompraBuilder addCupomAplicado(CupomAplicado cupomAplicado) {
        this.cupomAplicado = cupomAplicado;
        return this;
    }

    public Compra build() {
        return new Compra(this);
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

    public Pais getPais() {
        return pais;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public Function<Compra, Carrinho> getFuncaoCriaCarrinho() {
        return funcaoCriaCarrinho;
    }

    public CupomAplicado getCupomAplicado() {
        return cupomAplicado;
    }
}
