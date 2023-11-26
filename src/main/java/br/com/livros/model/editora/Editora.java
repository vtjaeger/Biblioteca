package br.com.livros.model.editora;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "editoras")
public class Editora {
    private Long id;
    private String nome;
}
