package br.com.livros.model.livro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoLivro(
        @NotNull
        Long id,
        String titulo,
        String autor,
        String descricao,
        String editora,
        String preco) {
}
