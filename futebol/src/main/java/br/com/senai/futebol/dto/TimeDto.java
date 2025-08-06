package br.com.senai.futebol.dto;

import java.util.ArrayList;
import java.util.List;

public class TimeDto {
    private Integer id;
    private String nome;
    private List<LinkDto> links = new ArrayList<LinkDto>();

    public TimeDto(String nome, Integer id) {
        this.nome = nome;
        this.id = id;
    }

    public void addLink(LinkDto link) {
        links.add(link);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<LinkDto> getLinks() {
        return links;
    }
}
