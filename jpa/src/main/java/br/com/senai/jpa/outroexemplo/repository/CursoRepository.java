package br.com.senai.jpa.outroexemplo.repository;


import br.com.senai.jpa.outroexemplo.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}
