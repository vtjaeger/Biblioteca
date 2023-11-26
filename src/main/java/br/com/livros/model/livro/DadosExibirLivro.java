package br.com.livros.model.livro;

public record DadosExibirLivro(String titulo, String autor, String descricao, String editora) {
    public DadosExibirLivro(Livro livro){
        this(livro.getTitulo(), livro.getAutor(), livro.getDescricao(), livro.getEditora());
    }
}
