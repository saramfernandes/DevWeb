package br.com.senai.jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlunoCursoDto {
    private Long idAluno;
    private Long idCurso;
    private int semestre;
}
