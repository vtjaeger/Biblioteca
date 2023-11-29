package br.com.livros.model.endereco;

import jakarta.validation.constraints.NotBlank;

public record DadosAtualizacaoEndereco(
        String uf,
        String bairro,
        String cidade,
        String rua,
        String numero,
        String complemento) {
    public DadosAtualizacaoEndereco(DadosAtualizacaoEndereco endereco) {
        this(endereco.uf(), endereco.bairro(), endereco.cidade(), endereco.rua(), endereco.numero(), endereco.complemento());
    }
}
