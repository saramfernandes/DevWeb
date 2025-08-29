package br.com.senai.jpa.dto;

import br.com.senai.jpa.model.Matricula;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDto {

    private Long id;
    private String nome;
    private String matricula;
    private String cursoPrincipal;
    private List<Matricula> matriculas = new ArrayList<Matricula>();

}
