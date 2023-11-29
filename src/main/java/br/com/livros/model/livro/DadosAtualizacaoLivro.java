package br.com.livros.model.livro;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoLivro(
        @NotNull
        Long id,
        String titulo,
        String autor,
        String descricao,
        String preco,
        Boolean disponivel,
        String editora_id) {
}
