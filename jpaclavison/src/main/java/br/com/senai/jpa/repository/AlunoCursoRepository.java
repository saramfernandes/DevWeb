package br.com.senai.jpa.repository;

import br.com.senai.jpa.model.Aluno;
import br.com.senai.jpa.model.AlunoCurso;
import br.com.senai.jpa.model.Curso;
import br.com.senai.jpa.model.ids.AlunoCursoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoCursoRepository extends JpaRepository<AlunoCurso, AlunoCursoId> {
    public List<AlunoCurso> findByAluno(Aluno aluno);
    public List<AlunoCurso> findByCurso(Curso curso);
}