package br.com.senai.jpa.onetomanyemanytomany.repository;

import br.com.senai.jpa.onetomanyemanytomany.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
