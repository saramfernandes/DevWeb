package br.com.senai.jpa.controller;

import br.com.senai.jpa.dto.ProdutoFiltroDto;
import br.com.senai.jpa.model.Produto;
import br.com.senai.jpa.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public Page<Produto> getProdutos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size) {
        return produtoService.getProdutosPaginados(page, size);
    }

    @PostMapping
    public ResponseEntity<Produto> criar(@RequestBody Produto produto) {
        Produto salvo = produtoService.create(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

//    @PostMapping
//    public ResponseEntity<Produto> criar(@RequestBody List<Produto> produto) {
//        for (Produto p: produto) {
//            Produto salvo = produtoService.create(p);
//        }
//        return ResponseEntity.status(HttpStatus.CREATED).body(null);
//    }

    @GetMapping("/filtro")
    public Page<Produto> listar(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String descricao,
            @RequestParam(required = false) String categoria,
            @RequestParam(required = false) Double precoMin,
            @RequestParam(required = false) Double precoMax,
            Pageable pageable
    ) {
        ProdutoFiltroDto filtro = new ProdutoFiltroDto();
        filtro.setNome(nome);
        filtro.setDescricao(descricao);
        filtro.setCategoria(categoria);
        filtro.setPrecoMin(precoMin);
        filtro.setPrecoMax(precoMax);
        return produtoService.listarComFiltros(filtro, pageable);
    }

}
