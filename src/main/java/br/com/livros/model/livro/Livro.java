package br.com.livros.model.livro;

import br.com.livros.model.editora.Editora;
import br.com.livros.model.editora.EditoraRepository;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
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

    @DecimalMax(value = "999999.99", message = "O preco deve conter apenas 2 casas decimais.")
    private BigDecimal preco;

    private Boolean disponivel;

//    @ManyToOne
    @JoinColumn(name = "editora_id")
    private String editora_id;

    public Livro(DadosCadastroLivro dadosLivro) {
        this.autor = dadosLivro.autor();
        this.titulo = dadosLivro.titulo();
        this.descricao = dadosLivro.descricao();
        this.preco = new BigDecimal(dadosLivro.preco().replace(',', '.'));
        this.disponivel = true;
        this.editora_id = dadosLivro.editora_id();
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
        if(dadosAtualizacao.preco() != null){
            this.preco = new BigDecimal(dadosAtualizacao.preco().replace(',','.'));
        }
        if(dadosAtualizacao.editora_id() != null){
            this.editora_id = dadosAtualizacao.editora_id();
        }
    }
    public void excluir(){
        this.disponivel = false;
    }
    public void ativar(){
        this.disponivel = true;
    }
}