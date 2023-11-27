package br.com.livros.model.livro;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record DadosCadastroLivro(
        @NotBlank
        String titulo,
        @NotBlank
        String autor,
        @NotBlank
        String descricao,
        @NotBlank
        String editora,
        @NotBlank
        String preco){
}
