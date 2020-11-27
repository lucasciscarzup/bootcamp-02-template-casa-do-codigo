package com.zup.lucasciscar.casadocodigo.compra;

import com.zup.lucasciscar.casadocodigo.autor.Autor;
import com.zup.lucasciscar.casadocodigo.categoria.Categoria;
import com.zup.lucasciscar.casadocodigo.livro.Livro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

public class CarrinhoTest {

    @DisplayName("Verifica se o total do Carrinho é igual ao passado como argumento")
    @ParameterizedTest
    @CsvSource({
            "10, true",
            "9.99, false",
            "10.01, false"
    })
    void testTotalCarrinhoIgualArgumento(BigDecimal valor, boolean resultadoEsperado) throws Exception {
        Autor autor = new Autor("Lucas", "lucas@zup.com.br", "Descrição Teste");
        Categoria categoria = new Categoria("TI");
        Livro livro = new Livro("Título Teste", "Resumo Teste", "Sumário Teste", BigDecimal.TEN, 100,
                "987654321", LocalDate.of(2020, 12, 25), categoria, autor);
        Set<ItemCarrinho> itens = Set.of(new ItemCarrinho(livro, 1));
        Carrinho carrinho = new Carrinho(Mockito.mock(Compra.class), BigDecimal.TEN, itens);

        Assertions.assertEquals(resultadoEsperado, carrinho.totalIgual(valor));
    }

}
