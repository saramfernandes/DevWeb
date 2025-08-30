package br.com.senai.jpa.outroexemplo.repository;


import br.com.senai.jpa.outroexemplo.model.Matricula;
import br.com.senai.jpa.outroexemplo.model.ids.AlunoCursoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, AlunoCursoId> {
}
