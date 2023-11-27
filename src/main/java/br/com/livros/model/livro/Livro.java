package br.com.livros.model.livro;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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

    private String editora;
    private BigDecimal preco;

    public Livro(DadosCadastroLivro dadosLivro) {
        this.autor = dadosLivro.autor();
        this.titulo = dadosLivro.titulo();
        this.descricao = dadosLivro.descricao();
        this.editora = dadosLivro.editora();
        this.preco = new BigDecimal(dadosLivro.preco().replace(',', '.'));
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
        if(dadosAtualizacao.editora() != null){
            this.editora = dadosAtualizacao.editora();
        }
        if(dadosAtualizacao.preco() != null){
            this.preco = new BigDecimal(dadosAtualizacao.preco().replace(',','.'));
        }
    }
}
