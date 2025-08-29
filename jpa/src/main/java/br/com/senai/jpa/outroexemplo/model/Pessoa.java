package br.com.senai.jpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private LocalDate dataNascimento;

    @OneToOne(mappedBy = "pessoa", cascade =
            CascadeType.ALL)
    private Documento documento;

}
