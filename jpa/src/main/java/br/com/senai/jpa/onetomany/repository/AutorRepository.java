package br.com.senai.jpa.onetomany.repository;

import br.com.senai.jpa.onetomany.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
}
