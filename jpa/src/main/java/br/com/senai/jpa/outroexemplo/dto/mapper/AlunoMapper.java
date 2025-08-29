package br.com.senai.jpa.dto.mapper;

import br.com.senai.jpa.dto.AlunoDto;
import br.com.senai.jpa.model.Aluno;

public class AlunoMapper {

    public static AlunoDto toDto(Aluno aluno) {
        return new AlunoDto(
                aluno.getId(),
                aluno.getNome(),
                aluno.getMatricula(),
                aluno.getCursoPrincipal(),
                aluno.getMatriculas()
        );
    }

    public static Aluno toEntity(AlunoDto alunoDto) {
        if (alunoDto == null){
            return null;
        }
        Aluno aluno = new Aluno();
        aluno.setId(alunoDto.getId());
        aluno.setNome(alunoDto.getNome());
        aluno.setMatricula(alunoDto.getMatricula());
        aluno.setCursoPrincipal(alunoDto.getCursoPrincipal());
        aluno.setMatriculas(alunoDto.getMatriculas());
        return aluno;
    }

}
