package br.com.avaliacao.notafiscal.controller;

import br.com.avaliacao.notafiscal.dto.LinkDto;
import br.com.avaliacao.notafiscal.dto.NotaFiscalDto;
import br.com.avaliacao.notafiscal.dto.ProdutoDto;
import br.com.avaliacao.notafiscal.service.NotaFiscalService;
import br.com.avaliacao.notafiscal.util.BancoDados;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notasfiscais")
public class NotaFiscalController {
    private int id = 1;

    @PostMapping
    public ResponseEntity<NotaFiscalDto> cadastrar(@RequestBody NotaFiscalDto notafiscal) {
        notafiscal.setId(id);
        BancoDados.notaFiscais.add(notafiscal);
        criarLinks(notafiscal);
        id++;
        return ResponseEntity.status(HttpStatus.CREATED).body(notafiscal);
    }

    @PostMapping("/{id}/adicionarProduto")
    public ResponseEntity<NotaFiscalDto> adicionarProduto(@PathVariable Long id, @RequestBody ProdutoDto produto) {
        for (NotaFiscalDto notafiscal : BancoDados.notaFiscais) {
            if (notafiscal.getId().equals(id)) {
                ProdutoDto produtoExistente = null;

                for (ProdutoDto p : BancoDados.produtos) {
                    if (p.getId().equals(produto.getId())) {
                        produtoExistente = p;
                        break;
                    }
                }
                if (produtoExistente == null) {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
                }

                notafiscal.getProdutos().add(produtoExistente);
                notafiscal.calcularTotal();
                return ResponseEntity.ok(notafiscal);
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping
    public ResponseEntity<List<NotaFiscalDto>> listarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(BancoDados.notaFiscais);
    }

    @GetMapping("/{numero}")
    public ResponseEntity<NotaFiscalDto> buscarPorId(@PathVariable Integer numero) {
        NotaFiscalDto notafiscalRetorno = NotaFiscalService.buscarPorNumero(numero);
        if (notafiscalRetorno == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(notafiscalRetorno);
    }

    @DeleteMapping("/{numero}")
    public ResponseEntity<NotaFiscalDto> excluir(@PathVariable Integer numero) {
        NotaFiscalDto notafiscalExcluir = NotaFiscalService.buscarPorNumero(numero);
        if (notafiscalExcluir == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            BancoDados.notaFiscais.remove(notafiscalExcluir);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/{numero}")
    public ResponseEntity<NotaFiscalDto> alterar(@PathVariable Integer numero, @RequestBody NotaFiscalDto notafiscal) {
        NotaFiscalDto notafiscalAlterar = NotaFiscalService.buscarPorNumero(numero);
        if (notafiscalAlterar == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            notafiscalAlterar.setNumero(notafiscal.getNumero());
            notafiscalAlterar.setProdutos(notafiscal.getProdutos());
            notafiscalAlterar.calcularTotal();
            return new ResponseEntity<>(notafiscalAlterar, HttpStatus.OK);
        }
    }



    private void criarLinks(NotaFiscalDto notafiscal) {
        notafiscal.addLink(new LinkDto("Cadastrar Produtos", "/notasfiscais/"+notafiscal.getId(), "POST"));
        notafiscal.addLink(new LinkDto("Buscar por Numero", "/notasfiscais/"+notafiscal.getNumero(), "GET"));
        notafiscal.addLink(new LinkDto("Alterar", "/notasfiscais/"+notafiscal.getId(), "PUT"));
        notafiscal.addLink(new LinkDto("Excluir", "/notasfiscais/"+notafiscal.getId(), "DELETE"));
    }

}
