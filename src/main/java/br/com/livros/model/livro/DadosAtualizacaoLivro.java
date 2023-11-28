package br.com.livros.model.livro;

import br.com.livros.model.editora.Editora;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosAtualizacaoLivro(
        @NotNull
        Long id,
        String titulo,
        String autor,
        String descricao,
        String preco,
        Boolean disponivel) {
}
