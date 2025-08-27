package br.com.senai.jpa.onetomanyemanytomany.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int cargaHoraria;
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<AlunoCurso> alunoCursos = new ArrayList<>();

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                ", alunoCursos=" + alunoCursos +
                '}';
    }
}
