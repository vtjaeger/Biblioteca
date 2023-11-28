package br.com.livros.controller;

import br.com.livros.model.editora.DadosCadastroEditora;
import br.com.livros.model.editora.Editora;
import br.com.livros.model.editora.EditoraRepository;
import br.com.livros.model.endereco.Endereco;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("editoras")
public class EditorasController {
    @Autowired
    private EditoraRepository repository;
    @PostMapping
    @Transactional
    public ResponseEntity<Editora> cadastrarEditora(@RequestBody @Valid DadosCadastroEditora dados,
                                                    UriComponentsBuilder uriComponentsBuilder){

        var endereco = new Endereco(dados.endereco());

        var editora = new Editora(dados, endereco);
        repository.save(editora);

        var uri = uriComponentsBuilder.path("/editoras/{id}").buildAndExpand(editora.getId()).toUri();
        return ResponseEntity.created(uri).body(editora);
    }
}