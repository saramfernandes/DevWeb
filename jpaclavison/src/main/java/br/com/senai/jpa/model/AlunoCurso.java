package br.com.senai.jpa.model;

import br.com.senai.jpa.model.ids.AlunoCursoId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "aluno_curso")
@Getter
@Setter
public class AlunoCurso {

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
