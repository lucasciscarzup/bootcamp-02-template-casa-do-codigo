package com.zup.lucasciscar.casadocodigo.compra;

import com.zup.lucasciscar.casadocodigo.cupom.Cupom;
import com.zup.lucasciscar.casadocodigo.cupom.CupomAplicado;
import com.zup.lucasciscar.casadocodigo.localidade.Estado;
import com.zup.lucasciscar.casadocodigo.localidade.Pais;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.function.Function;

@Entity
@Table(name = "compras")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    @ManyToOne
    private Pais pais;

    @ManyToOne
    private Estado estado;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    @OneToOne(mappedBy = "compra", cascade = CascadeType.PERSIST)
    private Carrinho carrinho;

    @Embedded
    private CupomAplicado cupomAplicado;

    @Deprecated
    public Compra() {

    }

    public Compra(CompraBuilder compraBuilder) {
        this.email = compraBuilder.getEmail();
        this.nome = compraBuilder.getNome();
        this.sobrenome = compraBuilder.getSobrenome();
        this.documento = compraBuilder.getDocumento();
        this.endereco = compraBuilder.getEndereco();
        this.complemento = compraBuilder.getComplemento();
        this.cidade = compraBuilder.getCidade();
        this.pais = compraBuilder.getPais();
        this.estado = compraBuilder.getEstado();
        this.telefone = compraBuilder.getTelefone();
        this.cep = compraBuilder.getCep();
        this.carrinho = compraBuilder.getFuncaoCriaCarrinho().apply(this);
        this.cupomAplicado = compraBuilder.getCupomAplicado();
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }

    public CupomAplicado getCupomAplicado() {
        return cupomAplicado;
    }

    public Long getId() {
        return id;
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

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }
}
