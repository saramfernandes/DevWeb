package br.com.senai.jpa.onetomanyemanytomany.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Column(unique = true)
    private String matricula;
    private String cursoPrincipal;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    private List<AlunoCurso> alunoCursos = new ArrayList<>();

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", matricula='" + matricula + '\'' +
                ", cursoPrincipal='" + cursoPrincipal + '\'' +
                ", alunoCursos=" + alunoCursos +
                '}';
    }
}
