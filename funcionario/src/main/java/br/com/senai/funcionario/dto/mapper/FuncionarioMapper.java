package br.com.senai.funcionario.dto.mapper;

import br.com.senai.funcionario.dto.FuncionarioDto;
import br.com.senai.funcionario.model.Funcionario;

public class FuncionarioMapper {
    public static FuncionarioDto toDto(Funcionario funcionario) {
        if(funcionario == null) return null;
        return new FuncionarioDto(
                funcionario.getNome(),
                funcionario.getCargo()
        );
    }

    public static Funcionario toEntity(FuncionarioDto dto) {
        if(dto == null) return null;
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(dto.getNome());
        funcionario.setCargo(dto.getCargo());
        return funcionario;
    }
}
