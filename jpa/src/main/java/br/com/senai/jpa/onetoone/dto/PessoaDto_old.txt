package br.com.senai.jpa.dto;

import java.time.LocalDate;

public class PessoaDto {

    private Long id;
    private String nome;
    private String email;
    private LocalDate dataNascimento;
    private DocumentoDto documento;

    public PessoaDto() {
    }

    public PessoaDto(Long id, String nome, String email, LocalDate dataNascimento,DocumentoDto documento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.documento = documento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DocumentoDto getDocumento() {
        return documento;
    }

    public void setDocumento(DocumentoDto documento) {
        this.documento = documento;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
