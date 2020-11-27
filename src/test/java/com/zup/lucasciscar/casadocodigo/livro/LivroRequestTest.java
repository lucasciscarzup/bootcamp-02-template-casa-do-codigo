package com.zup.lucasciscar.casadocodigo.livro;

import com.zup.lucasciscar.casadocodigo.autor.Autor;
import com.zup.lucasciscar.casadocodigo.categoria.Categoria;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class LivroRequestTest {

    private LivroRequest livroRequest = new LivroRequest("", "", "", BigDecimal.valueOf(100),
            200, "", 1L, 1L);

    @Test
    @DisplayName("Criar Livro com Categoria e Autor cadastrados")
    void testCriaLivroCategoriaAutor() throws Exception {
        EntityManager entityManager = Mockito.mock(EntityManager.class);

        Mockito.when(entityManager.find(Categoria.class, 1L)).thenReturn(new Categoria(""));
        Mockito.when(entityManager.find(Autor.class, 1L)).thenReturn(new Autor("", "", ""));

        Assertions.assertNotNull(livroRequest.toModel(entityManager));
    }

}
