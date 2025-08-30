package br.com.senai.jpa.outroexemplo.dto;

import br.com.senai.jpa.outroexemplo.model.Matricula;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CursoDto {

    private Long id;
    private String nome;
    private int cargaHoraria;
    private List<Matricula> matriculas = new ArrayList<Matricula>();

}
