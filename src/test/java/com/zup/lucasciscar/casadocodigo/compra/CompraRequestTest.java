package com.zup.lucasciscar.casadocodigo.compra;

import com.zup.lucasciscar.casadocodigo.autor.Autor;
import com.zup.lucasciscar.casadocodigo.categoria.Categoria;
import com.zup.lucasciscar.casadocodigo.cupom.Cupom;
import com.zup.lucasciscar.casadocodigo.cupom.CupomRepository;
import com.zup.lucasciscar.casadocodigo.livro.Livro;
import com.zup.lucasciscar.casadocodigo.localidade.Estado;
import com.zup.lucasciscar.casadocodigo.localidade.Pais;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class CompraRequestTest {

    private EntityManager entityManager = Mockito.mock(EntityManager.class);
    private CupomRepository cupomRepository = Mockito.mock(CupomRepository.class);

    private List<ItemCarrinhoRequest> itens = List.of(new ItemCarrinhoRequest(1L, 5));
    private CarrinhoRequest carrinho = new CarrinhoRequest(new BigDecimal(50), itens);

    private Pais pais = new Pais("Brasil");
    private Autor autor = new Autor("Lucas", "lucas@zup.com.br", "Descrição Teste");
    private Categoria categoria = new Categoria("TI");
    private Livro livro = new Livro("Título Teste", "Resumo Teste", "Sumário Teste", BigDecimal.TEN, 100,
            "987654321", LocalDate.of(2020, 12, 25), categoria, autor);

    {
        Mockito.when(entityManager.find(Pais.class, 1L)).thenReturn(pais);
        Mockito.when(entityManager.find(Estado.class, 1L)).thenReturn(new Estado("São Paulo", pais));
        Mockito.when(entityManager.find(Livro.class, 1L)).thenReturn(livro);
        Mockito.when(cupomRepository.findByCodigo("codigo-cupom"))
                .thenReturn(new Cupom("codigo-cupom", BigDecimal.TEN, LocalDate.now().plusDays(1L)));
    }

    private CompraRequest compraRequest = new CompraRequest("lucas@zup.com.br", "Lucas", "Ciscar",
            "11111111111", "Rua Exemplo", "Fundos", "São Paulo", 1L,
            "11111111", "11111111", carrinho);

    @Test
    @DisplayName("Cria Compra com Estado e com Cupom")
    void testCompraEstadoCupom() throws Exception {
        compraRequest.setCodigoCupom("codigo-cupom");
        compraRequest.setIdEstado(1L);
        Compra compra = compraRequest.toModel(entityManager, cupomRepository);

        Assertions.assertNotNull(compra);
        Mockito.verify(entityManager).find(Estado.class, 1L);
        Mockito.verify(cupomRepository).findByCodigo("codigo-cupom");
    }

    @Test
    @DisplayName("Cria Compra sem Estado e com Cupom")
    void testCompraSemEstadoCupom() throws Exception {
        compraRequest.setCodigoCupom("codigo-cupom");
        Compra compra = compraRequest.toModel(entityManager, cupomRepository);

        Assertions.assertNotNull(compra);
        Mockito.verify(entityManager, Mockito.never()).find(Mockito.eq(Estado.class), Mockito.anyLong());
        Mockito.verify(cupomRepository).findByCodigo("codigo-cupom");
    }

    @Test
    @DisplayName("Cria Compra sem Estado e sem Cupom")
    void testCompraSemEstadoSemCupom() throws Exception {
        Compra compra = compraRequest.toModel(entityManager, cupomRepository);

        Assertions.assertNotNull(compra);
        Mockito.verify(entityManager, Mockito.never()).find(Mockito.eq(Estado.class), Mockito.anyLong());
        Mockito.verify(cupomRepository, Mockito.never()).findByCodigo(Mockito.anyString());
    }

    @ParameterizedTest
    @DisplayName("Verifica documento válido")
    @CsvSource({
            "33121811002, true",
            "43673382000127, true",
            "987654321, false"
    })
    void testDocumentoValido(String documento, boolean resultadoEsperado) throws Exception {
        CompraRequest compraRequest = new CompraRequest("lucas@zup.com.br", "Lucas", "Ciscar",
                documento, "Rua Exemplo", "Fundos", "São Paulo", 1L,
                "11111111", "11111111", carrinho);

        Assertions.assertEquals(resultadoEsperado, compraRequest.documentoValido());
    }

}
