package br.com.livros.model.editora;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroEditora(@NotBlank String nome) {
}
