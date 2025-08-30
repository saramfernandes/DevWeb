package br.com.senai.jpa.outroexemplo.dto.mapper;


import br.com.senai.jpa.outroexemplo.dto.AlunoCursoDto;
import br.com.senai.jpa.outroexemplo.model.AlunoCurso;
import br.com.senai.jpa.outroexemplo.model.ids.AlunoCursoId;

public class AlunoCursoMapper {

    public static AlunoCursoDto toDto(AlunoCurso alunoCurso) {
        if (alunoCurso == null) return null;
        return new AlunoCursoDto(
                alunoCurso.getId().getAlunoId(),
                alunoCurso.getId().getCursoId(),
                alunoCurso.getSemestre()
        );
    }

    public static AlunoCurso toEntity(AlunoCursoDto dto) {
        if (dto == null) return null;
        AlunoCursoId id = new AlunoCursoId();
        id.setAlunoId(dto.getIdAluno());
        id.setCursoId(dto.getIdCurso());

        AlunoCurso alunoCurso = new AlunoCurso();
        alunoCurso.setId(id);
        alunoCurso.setSemestre(dto.getSemestre());

        return alunoCurso;
    }
}
