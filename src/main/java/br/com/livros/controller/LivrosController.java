package br.com.livros.controller;

import br.com.livros.model.livro.DadosCadastroLivro;
import br.com.livros.model.livro.Livro;
import br.com.livros.model.livro.LivroRepository;
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
@RequestMapping("livros")
public class LivrosController {
    @Autowired
    private LivroRepository repository;
    @PostMapping
    @Transactional
    public ResponseEntity<Livro> cadastrarLivro(@RequestBody @Valid DadosCadastroLivro dadosLivro,
                                         UriComponentsBuilder uriComponentsBuilder) {
        var livro = new Livro(dadosLivro);
        repository.save(livro);

        var uri = uriComponentsBuilder.path("/livros/{id}").buildAndExpand(livro.getId()).toUri();
        return ResponseEntity.created(uri).body(livro);
    }

}
