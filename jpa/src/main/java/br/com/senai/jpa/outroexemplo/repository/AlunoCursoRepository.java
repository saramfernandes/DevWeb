package br.com.senai.jpa.outroexemplo.repository;

import br.com.senai.jpa.outroexemplo.model.Aluno;
import br.com.senai.jpa.outroexemplo.model.AlunoCurso;
import br.com.senai.jpa.outroexemplo.model.Curso;
import br.com.senai.jpa.outroexemplo.model.ids.AlunoCursoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoCursoRepository extends JpaRepository<AlunoCurso, AlunoCursoId> {
    public List<AlunoCurso> findByAluno(Aluno aluno);
    public List<AlunoCurso> findByCurso(Curso curso);
}
