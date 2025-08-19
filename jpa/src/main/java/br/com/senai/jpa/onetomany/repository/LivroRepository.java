package br.com.senai.jpa.onetomany.repository;

import br.com.senai.jpa.onetomany.model.Autor;
import br.com.senai.jpa.onetomany.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    public List<Livro> findByAutor(Autor autor);
}
