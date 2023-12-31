package br.com.livros.model.editora;

import br.com.livros.model.endereco.DadosEndereco;
import br.com.livros.model.endereco.Endereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroEditora(
        @NotBlank
        String nome,
        @Valid
        DadosEndereco endereco) {
}
