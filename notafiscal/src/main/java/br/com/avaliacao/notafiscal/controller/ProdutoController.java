package br.com.avaliacao.notafiscal.controller;

import br.com.avaliacao.notafiscal.dto.LinkDto;
import br.com.avaliacao.notafiscal.dto.ProdutoDto;
import br.com.avaliacao.notafiscal.service.ProdutoService;
import br.com.avaliacao.notafiscal.util.BancoDados;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private int id = 1;

    @PostMapping
    public ResponseEntity<ProdutoDto> cadastrarProduto(@RequestBody ProdutoDto produto) {
        produto.setId(id);
        BancoDados.produtos.add(produto);
        criarLinks(produto);
        id++;
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDto>> listarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(BancoDados.produtos);
    }

    @GetMapping("/query")
    public ResponseEntity<ProdutoDto> buscarPorNome(@RequestParam String nome) {
        ProdutoDto produtoRetorno = null;
        for (ProdutoDto time: BancoDados.produtos) {
            if (time.getNome().equalsIgnoreCase(nome)) {
                produtoRetorno = time;
            }
        }
        if (produtoRetorno == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(produtoRetorno);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDto> buscarPorId(@PathVariable Integer id) {
        ProdutoDto produtoRetorno = ProdutoService.buscarPorId(id);
        if (produtoRetorno == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(produtoRetorno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProdutoDto> excluir(@PathVariable Integer id) {
        ProdutoDto produtoExcluir = ProdutoService.buscarPorId(id);
        if (produtoExcluir == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            BancoDados.produtos.remove(produtoExcluir);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDto> alterar(@PathVariable Integer id, @RequestBody ProdutoDto produto) {
        ProdutoDto produtoAlterar = ProdutoService.buscarPorId(id);
        if (produtoAlterar == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            produtoAlterar.setNome(produto.getNome());
            produtoAlterar.setDescricao(produto.getDescricao());
            produtoAlterar.setPreco(produto.getPreco());
            return new ResponseEntity<>(produtoAlterar, HttpStatus.OK);
        }
    }


    @GetMapping("/faixa-preco/{min}/{max}")
    public ResponseEntity<List<ProdutoDto>> buscarPorFaixaPreco(@RequestParam Float precoMin, @RequestParam Float precoMax) {

        List<ProdutoDto> produtosFiltrados = new ArrayList<>();

        for (ProdutoDto produto : BancoDados.produtos) {
            if (produto.getPreco() != null &&
                    produto.getPreco() >= precoMin &&
                    produto.getPreco() <= precoMax) {
                produtosFiltrados.add(produto);
            }
        }

        if (produtosFiltrados.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }

        return ResponseEntity.status(HttpStatus.OK).body(produtosFiltrados);
    }






    private void criarLinks(ProdutoDto produto) {
        produto.addLink(new LinkDto("Buscar por ID", "/produtos/"+produto.getId(), "GET"));
        produto.addLink(new LinkDto("Buscar por nome", "/produtos/query?nome="+produto.getNome(), "GET"));
        produto.addLink(new LinkDto("Buscar por faixa de preço", "/produtos/faixa-preco?precoMin={min}&precoMax={max}", "GET"));
        produto.addLink(new LinkDto("Alterar", "/produtos/"+produto.getId(), "PUT"));
        produto.addLink(new LinkDto("Excluir", "/produtos/"+produto.getId(), "DELETE"));
    }
}
