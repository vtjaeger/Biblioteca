package br.com.livros.model.livro;

import br.com.livros.model.editora.Editora;

public record DadosExibirLivro(String titulo, String autor, String descricao, String preco, String editora_id) {
    public DadosExibirLivro(Livro livro){
        this(livro.getTitulo(), livro.getAutor(), livro.getDescricao(), livro.getPreco().toString(),
                livro.getEditora_id());
    }
}