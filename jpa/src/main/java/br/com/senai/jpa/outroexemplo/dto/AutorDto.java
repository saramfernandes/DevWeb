package br.com.senai.jpa.outroexemplo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class AutorDto {

    private Long id;
    private String nome;
    private String nacionalidade;
    private LocalDate dataNascimento;

}
