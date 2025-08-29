package br.com.senai.jpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String cpf;

    private String rg;

    @OneToOne
    @JoinColumn(name = "pessoa_id", unique = true)
    private Pessoa pessoa;

}
