package br.com.livros.model.editora;

import br.com.livros.model.endereco.Endereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record DadosEditora(
        Long id,
        @NotBlank
        String nome,
        @Valid
        Endereco endereco) {
}
