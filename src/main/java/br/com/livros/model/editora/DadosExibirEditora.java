package br.com.livros.model.editora;

import br.com.livros.model.endereco.Endereco;
import com.fasterxml.jackson.annotation.JsonIgnore;

public record DadosExibirEditora(String id, String nome, Endereco endereco) {
    public DadosExibirEditora(Editora editora) {
        this(String.valueOf(editora.getId()), editora.getNome(), editora.getEndereco());
    }

}
