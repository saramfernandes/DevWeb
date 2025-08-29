package br.com.senai.jpa.dto;

import br.com.senai.jpa.model.Aluno;
import br.com.senai.jpa.model.AlunoCursoId;
import br.com.senai.jpa.model.Curso;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MatriculaDto {

    private AlunoCursoId id = new AlunoCursoId();
    private Aluno aluno;
    private Curso curso;
    private int semestre;

}
