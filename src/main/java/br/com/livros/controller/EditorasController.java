package br.com.livros.controller;

import br.com.livros.model.editora.*;
import br.com.livros.model.endereco.Endereco;
import br.com.livros.model.livro.DadosAtualizacaoLivro;
import br.com.livros.model.livro.DadosExibirLivro;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.function.Function;

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
    @GetMapping
    public ResponseEntity<Page<DadosExibirEditora>> exibirEditoras(@PageableDefault(size = 10) Pageable paginacao) {
        Page<DadosExibirEditora> page = repository.findByDisponivelTrue(paginacao)
                .map(DadosExibirEditora::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarEditora(@RequestBody @Valid DadosAtualizacaoEditora dadosAtualizacao){
        var editora = repository.getReferenceById(dadosAtualizacao.id());
        editora.atualizarInformacoes(dadosAtualizacao);

        return ResponseEntity.ok(new DadosExibirEditora(editora));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var editora = repository.getReferenceById(id);
        editora.excluir();
        return ResponseEntity.ok(new DadosExibirEditora(editora));
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity ativar(@PathVariable Long id){
        var editora = repository.getReferenceById(id);
        editora.ativar();
        return ResponseEntity.ok(new DadosExibirEditora(editora));
    }

}
