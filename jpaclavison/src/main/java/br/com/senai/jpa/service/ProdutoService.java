package br.com.senai.jpa.service;

import br.com.senai.jpa.dto.ProdutoFiltroDto;
import br.com.senai.jpa.dto.specification.ProdutoSpecification;
import br.com.senai.jpa.model.Produto;
import br.com.senai.jpa.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Page<Produto> getProdutosPaginados(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return produtoRepository.findAll(pageable);
    }

    public Produto create(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Page<Produto> listarComFiltros(ProdutoFiltroDto filtro, Pageable pageable) {
        return produtoRepository.findAll(ProdutoSpecification.comFiltros(filtro), pageable);
    }

}
