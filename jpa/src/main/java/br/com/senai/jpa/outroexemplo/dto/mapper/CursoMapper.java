package br.com.senai.jpa.outroexemplo.dto.mapper;


import br.com.senai.jpa.outroexemplo.dto.CursoDto;
import br.com.senai.jpa.outroexemplo.model.Curso;

public class CursoMapper {

    public static CursoDto toDto(Curso curso) {
        return new CursoDto(
                curso.getId(),
                curso.getNome(),
                curso.getCargaHoraria(),
                curso.getMatriculas()
        );
    }

    public static Curso toEntity(CursoDto cursoDto) {
        if (cursoDto == null){
            return null;
        }
        Curso curso = new Curso();
        curso.setId(cursoDto.getId());
        curso.setNome(cursoDto.getNome());
        curso.setCargaHoraria(cursoDto.getCargaHoraria());
        curso.setMatriculas(cursoDto.getMatriculas());
        return curso;
    }

}
