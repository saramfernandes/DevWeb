package br.com.senai.jpa.onetoone.dto;

import java.time.LocalDate;

public class PessoaDto {
    private Long id;
    private String nome;
    private String email;
    private LocalDate dataNascimento;
    private String cpf;
    private String rg;

    public PessoaDto() {
    }

    public PessoaDto(String nome, String email, LocalDate dataNascimento, String cpf, String rg, Long id) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.rg = rg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
}
