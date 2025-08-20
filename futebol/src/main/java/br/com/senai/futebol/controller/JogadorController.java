package br.com.senai.futebol.controller;

import br.com.senai.futebol.dto.JogadorDto;
import br.com.senai.futebol.dto.LinkDto;
import br.com.senai.futebol.dto.TimeDto;
import br.com.senai.futebol.service.JogadorService;
import br.com.senai.futebol.service.TimeService;
import br.com.senai.futebol.util.BancoDados;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {
    private int id = 1;

    @PostMapping
    public ResponseEntity<JogadorDto> cadastrar(@RequestBody JogadorDto jogador) {
        TimeDto time = TimeService.buscarPorId((jogador.getTime().getId()));
        if (time == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        jogador.setTime(time);
        jogador.setId(this.id);
        BancoDados.jogadores.add(jogador);
        criarLinks(jogador);

        this.id++;
        return ResponseEntity.status(HttpStatus.OK).body(jogador);
    }

    @GetMapping
    public ResponseEntity<List<JogadorDto>> listarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(BancoDados.jogadores);
    }

    @GetMapping("/query")
    public ResponseEntity<JogadorDto> buscarPorNome(@RequestParam String nome) {
        JogadorDto jogadorRetorno = null;
        for (JogadorDto jogador: BancoDados.jogadores) {
            if (jogador.getNome().equalsIgnoreCase(nome)) {
                jogadorRetorno = jogador;
            }
        }
        if (jogadorRetorno == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(jogadorRetorno);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JogadorDto> buscarPorId(@PathVariable Integer id) {
        JogadorDto jogadorRetorno = JogadorService.buscarPorId(id);
        if (jogadorRetorno == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(jogadorRetorno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<JogadorDto> excluir(@PathVariable Integer id) {
        JogadorDto jogadorExcluir = JogadorService.buscarPorId(id);
        if (jogadorExcluir == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            BancoDados.jogadores.remove(jogadorExcluir);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<JogadorDto> alterar(@PathVariable Integer id, @RequestBody JogadorDto jogador) {
        JogadorDto jogadorAlterar = JogadorService.buscarPorId(id);
        if (jogadorAlterar == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            jogadorAlterar.setNome(jogador.getNome());
            jogadorAlterar.setCamisa(jogador.getCamisa());
            TimeDto time = TimeService.buscarPorId((jogador.getTime().getId()));
            if (time == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            jogadorAlterar.setTime(time);
            return new ResponseEntity<>(jogadorAlterar, HttpStatus.OK);
        }
    }

    private void criarLinks(JogadorDto jogador) {
        jogador.addLink(new LinkDto("Buscar por ID", "/jogadores/"+jogador.getId(), "GET"));
        jogador.addLink(new LinkDto("Buscar por nome", "/jogadores/query?nome="+jogador.getNome(), "GET"));
        jogador.addLink(new LinkDto("Alterar", "/jogadores/"+jogador.getId(), "PUT"));
        jogador.addLink(new LinkDto("Excluir", "/jogadores/"+jogador.getId(), "DELETE"));
    }
}
