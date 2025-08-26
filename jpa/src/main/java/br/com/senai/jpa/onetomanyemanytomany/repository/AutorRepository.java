package br.com.senai.jpa.onetomanyemanytomany.repository;

import br.com.senai.jpa.onetomanyemanytomany.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
}
