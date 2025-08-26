package br.com.avaliacao.notafiscal.dto;

import java.util.ArrayList;
import java.util.List;

public class NotaFiscalDto {
    private Integer id;
    private Integer numero;
    private List<ProdutoDto> produtos = new ArrayList<ProdutoDto>();
    private List<LinkDto> links = new ArrayList<LinkDto>();
    private Float valorTotal;

    public void calcularTotal() {
        float soma = 0;
        for (ProdutoDto produto : produtos) {
            if (produto != null && produto.getPreco() != null) {
                soma += produto.getPreco();
            }
        }
        this.valorTotal = soma;
    }


    @Override
    public String toString() {
        return "NotaFiscalDto{" +
                "id=" + id +
                ", numero=" + numero +
                ", produtos=" + produtos +
                ", links=" + links +
                '}';
    }

    public NotaFiscalDto() {
    }

    public NotaFiscalDto(Integer id, Integer numero, List<ProdutoDto> produtos, List<LinkDto> links) {
        this.id = id;
        this.numero = numero;
        this.produtos = produtos;
        this.links = links;
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

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public List<ProdutoDto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoDto> produtos) {
        this.produtos = produtos;
    }

    public List<LinkDto> getLinks() {
        return links;
    }

    public void setLinks(List<LinkDto> links) {
        this.links = links;
    }
}
