package com.zup.lucasciscar.casadocodigo.compra;

import com.zup.lucasciscar.casadocodigo.cupom.Cupom;
import com.zup.lucasciscar.casadocodigo.cupom.CupomAplicado;
import com.zup.lucasciscar.casadocodigo.localidade.Estado;
import com.zup.lucasciscar.casadocodigo.localidade.Pais;

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

    public Compra(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
                  @NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
                  @NotBlank String cidade, @NotNull Pais pais, @NotBlank String telefone, @NotBlank String cep,
                  Function<Compra, Carrinho> funcaoCriaCarrinho) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.telefone = telefone;
        this.cep = cep;
        this.carrinho = funcaoCriaCarrinho.apply(this);
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void aplicaCupom(Cupom cupom) {
        this.cupomAplicado = new CupomAplicado(cupom);
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
