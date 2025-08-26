package br.com.avaliacao.notafiscal.service;

import br.com.avaliacao.notafiscal.dto.ProdutoDto;
import br.com.avaliacao.notafiscal.util.BancoDados;

public class ProdutoService {

    public static ProdutoDto buscarPorId(Integer id) {
        for (ProdutoDto produto: BancoDados.produtos) {
            if (produto.getId().equals(id)) {
                return produto;
            }
        }
        return null;
    }
}
