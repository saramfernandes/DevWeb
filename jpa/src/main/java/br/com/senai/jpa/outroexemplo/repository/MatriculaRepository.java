package br.com.senai.jpa.repository;

import br.com.senai.jpa.model.Matricula;
import br.com.senai.jpa.model.AlunoCursoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, AlunoCursoId> {
}
