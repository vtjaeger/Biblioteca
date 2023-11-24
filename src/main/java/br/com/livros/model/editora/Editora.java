package br.com.livros.model.editora;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "editoras")
@Entity(name = "Editora")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Editora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    public Editora(DadosCadastroEditora dadosEditora) {
        this.nome = dadosEditora.nome();
    }
}
