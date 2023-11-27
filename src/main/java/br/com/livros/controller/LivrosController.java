package br.com.livros.controller;

import br.com.livros.model.livro.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.sql.PreparedStatement;

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

    @GetMapping
    public ResponseEntity<Page<DadosExibirLivro>> exibirLivros(@PageableDefault(size = 10) Pageable paginacao) {
        var page = repository.findByDisponivelTrue(paginacao)
                .map(DadosExibirLivro::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarLivro(@RequestBody @Valid DadosAtualizacaoLivro dadosAtualizacao){
        var livro = repository.getReferenceById(dadosAtualizacao.id());
        livro.atualizarInformacoes(dadosAtualizacao);

        return ResponseEntity.ok(new DadosExibirLivro(livro));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var livro = repository.getReferenceById(id);
        livro.excluir();
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity ativar(@PathVariable Long id){
        var livro = repository.getReferenceById(id);
        livro.ativar();
        return ResponseEntity.ok(new DadosExibirLivro(livro));
    }
}
