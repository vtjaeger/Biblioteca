package br.com.livros.model.editora;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EditoraRepository extends JpaRepository<Editora, Long> {
    Page<Editora> findByDisponivelTrue(Pageable paginacao);
}
