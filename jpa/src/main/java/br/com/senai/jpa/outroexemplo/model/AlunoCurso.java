package br.com.senai.jpa.outroexemplo.model;

import br.com.senai.jpa.outroexemplo.model.ids.AlunoCursoId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "aluno_curso")
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

    @Override
    public String toString() {
        return "AlunoCurso{" +
                "id=" + id +
                ", aluno=" + aluno +
                ", curso=" + curso +
                ", semestre=" + semestre +
                '}';
    }
}
