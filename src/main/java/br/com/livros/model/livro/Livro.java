package br.com.livros.model.livro;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "livros")
@Entity(name = "Livro")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;
    private String descricao;

    public Livro(DadosCadastroLivro dadosLivro) {
        this.autor = dadosLivro.autor();
        this.titulo = dadosLivro.titulo();
        this.descricao = dadosLivro.descricao();
    }

    public void atualizarInformacoes(DadosAtualizacaoLivro dadosAtualizacao){
        if(dadosAtualizacao.autor() != null){
            this.autor = dadosAtualizacao.autor();
        }
        if(dadosAtualizacao.titulo() != null){
            this.titulo = dadosAtualizacao.titulo();
        }
        if(dadosAtualizacao.descricao() != null){
            this.descricao = dadosAtualizacao.descricao();
        }
    }
}
