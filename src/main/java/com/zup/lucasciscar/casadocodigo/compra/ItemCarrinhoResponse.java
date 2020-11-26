package com.zup.lucasciscar.casadocodigo.compra;

import com.zup.lucasciscar.casadocodigo.livro.LivroIdTituloResponse;

public class ItemCarrinhoResponse {

    private LivroIdTituloResponse livro;
    private int quantidade;

    public ItemCarrinhoResponse(ItemCarrinho itemCarrinho) {
        this.livro = new LivroIdTituloResponse(itemCarrinho.getLivro().getId(), itemCarrinho.getLivro().getTitulo());
        this.quantidade = itemCarrinho.getQuantidade();
    }

    public LivroIdTituloResponse getLivro() {
        return livro;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
