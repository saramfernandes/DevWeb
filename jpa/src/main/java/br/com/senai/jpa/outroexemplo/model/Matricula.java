package br.com.senai.jpa.outroexemplo.model;

import br.com.senai.jpa.outroexemplo.model.ids.AlunoCursoId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "matricula")
public class Matricula {

    @EmbeddedId
    private AlunoCursoId id = new AlunoCursoId();

    @ManyToOne
    @MapsId("alunoId")
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @MapsId("cursoId")
    @JoinColumn(name = "curso_id")
    private Curso curso;

    private int semestre;

}
