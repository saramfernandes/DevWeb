package br.com.senai.jpa.onetoone.model;

import jakarta.persistence.*;

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

    @Override
    public String toString() {
        return "Documento{" +
                "pessoa=" + pessoa +
                ", cpf='" + cpf + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
