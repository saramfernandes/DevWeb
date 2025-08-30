package br.com.senai.jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDto {
    private Long id;
    private String nome;
    private String matricula;
    private String cursoPrincipal;
}
