package br.com.senai.jpa.dto.mapper;

import br.com.senai.jpa.dto.AlunoDto;
import br.com.senai.jpa.model.Aluno;

public class AlunoMapper {

    public static AlunoDto toDto(Aluno aluno) {
        if(aluno == null) return null;
        return new AlunoDto(
                aluno.getId(),
                aluno.getNome(),
                aluno.getMatricula(),
                aluno.getCursoPrincipal()
        );
    }

    public static Aluno toEntity(AlunoDto dto) {
        if(dto == null) return null;
        Aluno aluno = new Aluno();
        aluno.setId(dto.getId());
        aluno.setNome(dto.getNome());
        aluno.setMatricula(dto.getMatricula());
        aluno.setCursoPrincipal(dto.getCursoPrincipal());
        return aluno;
    }
}
