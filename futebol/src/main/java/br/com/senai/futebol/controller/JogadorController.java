package br.com.senai.futebol.controller;

import br.com.senai.futebol.dto.JogadorDto;
import br.com.senai.futebol.dto.LinkDto;
import br.com.senai.futebol.dto.TimeDto;
import br.com.senai.futebol.service.TimeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {
    private int id = 1;

    public ResponseEntity<JogadorDto> cadastrar(@RequestBody JogadorDto jogador) {
        TimeDto time = TimeService.buscarPorId((jogador.getTime().getId()));
        if (time == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        jogador.setTime(time);
        jogador.setId(this.id);

        criarLinks(jogador);

        this.id++;
        return ResponseEntity.status(HttpStatus.OK).body(jogador);
    }

    private void criarLinks(JogadorDto jogador) {
        jogador.addLink(new LinkDto("Buscar por ID", "/times/"+jogador.getId(), "GET"));
        jogador.addLink(new LinkDto("Buscar por nome", "/times/query?nome="+jogador.getNome(), "GET"));
        jogador.addLink(new LinkDto("Alterar", "/times/"+jogador.getId(), "PUT"));
        jogador.addLink(new LinkDto("Excluir", "/times/"+jogador.getId(), "DELETE"));
    }
}
