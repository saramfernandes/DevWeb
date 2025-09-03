package br.com.senai.jpa.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProdutoFiltroDto {
    private String nome;
    private String descricao;
    private String categoria;
    private Double precoMin;
    private Double precoMax;
}
