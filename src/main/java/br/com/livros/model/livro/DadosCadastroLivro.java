package br.com.livros.model.livro;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroLivro(
        @NotBlank
        String titulo,
        @NotBlank
        String autor,
        @NotBlank
        String descricao,
        @NotBlank
        String editora,
        String preco){
}
