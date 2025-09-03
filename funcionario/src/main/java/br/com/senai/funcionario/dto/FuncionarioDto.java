package br.com.senai.funcionario.dto;

import br.com.senai.funcionario.model.Cargo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDto {
    private String nome;
    private Cargo cargo;
}
