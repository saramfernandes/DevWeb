package br.com.avaliacao.notafiscal.dto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDto {
    private Integer id;
    private String nome;
    private String descricao;
    private Float preco;
    private List<LinkDto> links = new ArrayList<LinkDto>();

    @Override
    public String toString() {
        return "ProdutoDto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }

    public ProdutoDto() {
    }

    public ProdutoDto(Integer id, String nome, Float preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public void addLink(LinkDto link) {
        links.add(link);
    }

    public String getDescricao() {
        return descricao;
    }

    public List<LinkDto> getLinks() {
        return links;
    }

    public void setLinks(List<LinkDto> links) {
        this.links = links;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }
}
