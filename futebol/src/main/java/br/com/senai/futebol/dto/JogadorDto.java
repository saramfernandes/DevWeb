package br.com.senai.futebol.dto;

import java.util.ArrayList;
import java.util.List;

public class JogadorDto {
    private Integer id;
    private String nome;
    private Integer camisa;
    private TimeDto time;
    private List<LinkDto> links = new ArrayList<LinkDto>();

    public JogadorDto(Integer id, String nome, Integer camisa, TimeDto time) {
        this.id = id;
        this.nome = nome;
        this.camisa = camisa;
        this.time = time;
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

    public Integer getCamisa() {
        return camisa;
    }

    public void setCamisa(Integer camisa) {
        this.camisa = camisa;
    }

    public TimeDto getTime() {
        return time;
    }

    public void setTime(TimeDto time) {
        this.time = time;
    }

    public List<LinkDto> getLinks() {
        return links;
    }

    public void setLinks(List<LinkDto> links) {
        this.links = links;
    }
}
