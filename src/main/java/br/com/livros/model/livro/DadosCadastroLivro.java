package br.com.livros.model.livro;

import br.com.livros.model.editora.DadosCadastroEditora;
import br.com.livros.model.editora.Editora;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosCadastroLivro(
        @NotBlank
        String titulo,
        @NotBlank
        String autor,
        @NotBlank
        String descricao,
        @NotBlank
        String preco){
}