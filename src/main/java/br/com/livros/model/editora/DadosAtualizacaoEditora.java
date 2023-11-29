package br.com.livros.model.editora;

import br.com.livros.model.endereco.DadosAtualizacaoEndereco;
import br.com.livros.model.endereco.DadosEndereco;
import br.com.livros.model.endereco.Endereco;
import br.com.livros.model.livro.DadosAtualizacaoLivro;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoEditora(
        @NotNull
        Long id,
        String nome,
        @Valid
        DadosAtualizacaoEndereco endereco) {
}
