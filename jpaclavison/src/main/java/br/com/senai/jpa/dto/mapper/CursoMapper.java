package br.com.senai.jpa.dto.mapper;

import br.com.senai.jpa.dto.CursoDto;
import br.com.senai.jpa.model.Curso;

public class CursoMapper {

    public static CursoDto toDto(Curso curso) {
        if(curso == null) return null;
        return new CursoDto(
                curso.getId(),
                curso.getNome(),
                curso.getCargaHoraria()
        );
    }

    public static Curso toEntity(CursoDto dto) {
        if(dto == null) return null;
        Curso curso = new Curso();
        curso.setId(dto.getId());
        curso.setNome(dto.getNome());
        curso.setCargaHoraria(dto.getCargaHoraria());
        return curso;
    }
}
