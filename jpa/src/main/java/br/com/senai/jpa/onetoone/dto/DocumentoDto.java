package br.com.senai.jpa.onetoone.dto;

public class DocumentoDto {

    private Long id;
    private String cpf;
    private String rg;

    public DocumentoDto() {
    }

    public DocumentoDto(Long id, String rg, String cpf) {
        this.id = id;
        this.rg = rg;
        this.cpf = cpf;
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
