package br.com.livros.model.endereco;

import jakarta.validation.constraints.NotBlank;

public record DadosEndereco(
        @NotBlank
        String uf,
        @NotBlank
        String bairro,
        @NotBlank
        String cidade,
        @NotBlank
        String rua,
        @NotBlank
        String numero,
        String complemento) {
}
