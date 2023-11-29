package br.com.livros.model.endereco;

import br.com.livros.model.livro.DadosAtualizacaoLivro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
    private String uf;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;
    private String complemento;

    public Endereco(DadosEndereco endereco) {
        this.uf = endereco.uf();
        this.cidade = endereco.cidade();
        this.bairro = endereco.bairro();
        this.rua = endereco.rua();
        this.numero = endereco.numero();
        this.complemento = endereco.complemento();
    }

    public Endereco(DadosAtualizacaoEndereco endereco) {
        if(endereco.uf() != null){
            this.uf = endereco.uf();
        }
        if(endereco.cidade() != null){
            this.cidade = endereco.cidade();
        }
        if(endereco.rua() != null){
            this.rua = endereco.rua();
        }
        if(endereco.numero() != null){
            this.numero = endereco.numero();
        }
        if(endereco.complemento() != null){
            this.complemento = endereco.complemento();
        }
    }
    public void atualizarInformacoes(DadosAtualizacaoEndereco dadosAtualizacao) {
        if (dadosAtualizacao.uf() != null) {
            this.uf = dadosAtualizacao.uf();
        }
        if (dadosAtualizacao.bairro() != null) {
            this.bairro = dadosAtualizacao.bairro();
        }
        if (dadosAtualizacao.cidade() != null) {
            this.cidade = dadosAtualizacao.cidade();
        }
        if (dadosAtualizacao.rua() != null) {
            this.rua = dadosAtualizacao.rua();
        }
        if (dadosAtualizacao.numero() != null) {
            this.numero = dadosAtualizacao.numero();
        }
        if (dadosAtualizacao.complemento() != null) {
            this.complemento = dadosAtualizacao.complemento();
        }
    }
}