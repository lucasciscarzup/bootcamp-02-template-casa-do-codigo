package com.zup.lucasciscar.casadocodigo.compra;

import com.zup.lucasciscar.casadocodigo.cupom.Cupom;
import com.zup.lucasciscar.casadocodigo.cupom.CupomRepository;
import com.zup.lucasciscar.casadocodigo.localidade.Estado;
import com.zup.lucasciscar.casadocodigo.localidade.Pais;
import com.zup.lucasciscar.casadocodigo.compartilhado.validator.ExistsObject;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

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
    @ExistsObject(domainClass = Pais.class, fieldName = "id")
    private Long idPais;

    @ExistsObject(domainClass = Estado.class, fieldName = "id")
    private Long idEstado;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    @Valid
    @NotNull
    private CarrinhoRequest carrinhoRequest;

    @ExistsObject(domainClass = Cupom.class, fieldName = "codigo")
    private String codigoCupom;

    public CompraRequest(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
                         @NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
                         @NotBlank String cidade, @NotNull Long idPais, @NotBlank String telefone,
                         @NotBlank String cep, @Valid @NotNull CarrinhoRequest carrinhoRequest) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.idPais = idPais;
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

    public String getCodigoCupom() {
        return codigoCupom;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public void setCodigoCupom(String codigoCupom) {
        this.codigoCupom = codigoCupom;
    }

    public boolean documentoValido() {
        Assert.hasLength(documento, "Documento não pode ser nulo");

        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.initialize(null);

        CNPJValidator cnpjValidator = new CNPJValidator();
        cnpjValidator.initialize(null);

        return cpfValidator.isValid(documento, null) ||
                cnpjValidator.isValid(documento, null);
    }

    public Compra toModel(EntityManager entityManager, CupomRepository cupomRepository) {
        Pais pais = entityManager.find(Pais.class, idPais);

        Function<Compra, Carrinho> funcaoCriaCarrinho = carrinhoRequest.toModel(entityManager);
        Compra compra = new Compra(email, nome, sobrenome, documento, endereco, complemento, cidade, pais,
                                            telefone, cep, funcaoCriaCarrinho);
        if(idEstado != null)
            compra.setEstado(entityManager.find(Estado.class, idEstado));

        if(StringUtils.hasText(codigoCupom)) {
            Cupom cupom = cupomRepository.findByCodigo(codigoCupom);
            compra.aplicaCupom(cupom);
        }

        return compra;
    }

}
