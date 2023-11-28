ALTER TABLE livros
ADD COLUMN editora_id BIGINT,
ADD CONSTRAINT fk_livro_editora FOREIGN KEY (editora_id) REFERENCES editoras(id);
