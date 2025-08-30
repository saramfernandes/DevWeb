package br.com.senai.jpa.dto;

public class DocumentoDto {
    private Long id;
    private String cpf;
    private String rg;

    public DocumentoDto() {
    }

    public DocumentoDto(Long id, String cpf, String rg) {
        this.id = id;
        this.cpf = cpf;
        this.rg = rg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
