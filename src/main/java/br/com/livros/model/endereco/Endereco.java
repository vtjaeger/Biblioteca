package br.com.livros.model.endereco;

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
}