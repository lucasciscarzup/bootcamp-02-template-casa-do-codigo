package com.zup.lucasciscar.casadocodigo.dto.request;

import com.zup.lucasciscar.casadocodigo.entity.Carrinho;
import com.zup.lucasciscar.casadocodigo.entity.Compra;
import com.zup.lucasciscar.casadocodigo.entity.Estado;
import com.zup.lucasciscar.casadocodigo.entity.Pais;
import com.zup.lucasciscar.casadocodigo.validator.ExistsId;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.function.Function;

public class CompraRequest {

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
    @ExistsId(domainClass = Pais.class)
    private Long idPais;

    @ExistsId(domainClass = Estado.class)
    private Long idEstado;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    @Valid
    @NotNull
    private CarrinhoRequest carrinhoRequest;

    public CompraRequest(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
                         @NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
                         @NotBlank String cidade, @NotNull Long idPais, Long idEstado, @NotBlank String telefone,
                         @NotBlank String cep, @Valid @NotNull CarrinhoRequest carrinhoRequest) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.idPais = idPais;
        this.idEstado = idEstado;
        this.telefone = telefone;
        this.cep = cep;
        this.carrinhoRequest = carrinhoRequest;
    }

    public String getDocumento() {
        return documento;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public CarrinhoRequest getCarrinhoRequest() {
        return carrinhoRequest;
    }

    public Compra toModel(EntityManager entityManager) {
        Pais pais = entityManager.find(Pais.class, idPais);

        Function<Compra, Carrinho> funcaoCriaCarrinho = carrinhoRequest.toModel(entityManager);
        Compra compra = new Compra(email, nome, sobrenome, documento, endereco, complemento, cidade, pais,
                                            telefone, cep, funcaoCriaCarrinho);
        if(idEstado != null) {
            compra.setEstado(entityManager.find(Estado.class, idEstado));
        }

        return compra;
    }

}
