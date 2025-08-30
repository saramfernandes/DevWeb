package br.com.senai.jpa.outroexemplo.dto.mapper;


import br.com.senai.jpa.outroexemplo.dto.MatriculaDto;
import br.com.senai.jpa.outroexemplo.model.Matricula;

public class MatriculaMapper {

    public static MatriculaDto toDto(Matricula matricula) {
        return new MatriculaDto(
                matricula.getId(),
                matricula.getAluno(),
                matricula.getCurso(),
                matricula.getSemestre()
        );
    }

    public static Matricula toEntity(MatriculaDto matriculaDto) {
        if (matriculaDto == null){
            return null;
        }
        Matricula matricula = new Matricula();
        matricula.setId(matriculaDto.getId());
        matricula.setAluno(matriculaDto.getAluno());
        matricula.setCurso(matriculaDto.getCurso());
        matricula.setSemestre(matriculaDto.getSemestre());
        return matricula;
    }

}
