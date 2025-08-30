package br.com.senai.jpa.outroexemplo.dto;


import br.com.senai.jpa.outroexemplo.model.Aluno;
import br.com.senai.jpa.outroexemplo.model.Curso;
import br.com.senai.jpa.outroexemplo.model.ids.AlunoCursoId;
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
