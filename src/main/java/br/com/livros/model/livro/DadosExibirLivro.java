package br.com.livros.model.livro;

public record DadosExibirLivro(String titulo, String autor, String descricao) {
    public DadosExibirLivro(Livro livro){
        this(livro.getTitulo(), livro.getAutor(), livro.getDescricao());
    }
}
