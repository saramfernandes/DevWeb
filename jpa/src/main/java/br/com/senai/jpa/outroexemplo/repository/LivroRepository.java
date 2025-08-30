package br.com.senai.jpa.outroexemplo.repository;


import br.com.senai.jpa.outroexemplo.model.Autor;
import br.com.senai.jpa.outroexemplo.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro,Long> {

    List<Livro> findByAutor(Autor autor);

}
