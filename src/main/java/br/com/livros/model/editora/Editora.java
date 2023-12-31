package br.com.livros.model.editora;

import br.com.livros.model.endereco.DadosAtualizacaoEndereco;
import br.com.livros.model.endereco.DadosEndereco;
import br.com.livros.model.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "editoras")
@Entity(name = "editora")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Editora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Boolean disponivel;

    @Embedded
    private Endereco endereco;

    public Editora(DadosCadastroEditora dados, Endereco endereco) {
        this.nome = dados.nome();
        this.endereco = endereco;
        this.disponivel = true;
    }
    public Editora(Long id) {
        this.id = id;
    }

    public void atualizarInformacoes(DadosAtualizacaoEditora dadosAtualizacao) {
        if(dadosAtualizacao.nome() != null){
            this.nome = dadosAtualizacao.nome();
        }
        if (dadosAtualizacao.endereco() != null) {
            this.endereco.atualizarInformacoes(dadosAtualizacao.endereco());
        }
        if(dadosAtualizacao.disponivel() != null){
            this.disponivel = dadosAtualizacao.disponivel();
        }
    }

    public void excluir() {
        this.disponivel = false;
    }

    public void ativar() {
        this.disponivel = true;
    }
}
