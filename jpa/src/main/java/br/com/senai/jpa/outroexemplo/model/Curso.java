package br.com.senai.jpa.outroexemplo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private int cargaHoraria;

    @OneToMany(mappedBy = "curso", cascade =  CascadeType.ALL)
    private List<Matricula> matriculas = new ArrayList<Matricula>();

}
