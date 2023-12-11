package br.com.livros.model.editora;

import br.com.livros.model.endereco.DadosAtualizacaoEndereco;
import br.com.livros.model.endereco.DadosEndereco;
import br.com.livros.model.endereco.Endereco;
import br.com.livros.model.livro.DadosAtualizacaoLivro;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import javax.swing.text.StyledEditorKit;

public record DadosAtualizacaoEditora(
        @NotNull
        Long id,
        String nome,
        Boolean disponivel,
        @Valid
        DadosAtualizacaoEndereco endereco) {
}
