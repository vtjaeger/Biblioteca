package br.com.livros.controller;

import br.com.livros.model.editora.DadosCadastroEditora;
import br.com.livros.model.editora.Editora;
import br.com.livros.model.editora.EditoraRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("editoras")
public class EditoraController {
    @Autowired
    private EditoraRepository repository;
    @PostMapping
    @Transactional
    public ResponseEntity<Editora> cadastrarEditora(@RequestBody @Valid DadosCadastroEditora dadosEditora,
                                                    UriComponentsBuilder uriComponentsBuilder){
        var editora = new Editora(dadosEditora);
        repository.save(editora);

        var uri = uriComponentsBuilder.path("/editoras/{id}").buildAndExpand(editora.getId()).toUri();
        return ResponseEntity.created(uri).body(editora);
    }

}
