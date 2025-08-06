package br.com.senai.futebol.controller;

import br.com.senai.futebol.dto.LinkDto;
import br.com.senai.futebol.dto.TimeDto;
import br.com.senai.futebol.service.TimeService;
import br.com.senai.futebol.util.BancoDados;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/times")
public class TimeController {
    private int id = 1;

    @GetMapping("/query")
    public ResponseEntity<TimeDto> buscarPorNome(@RequestParam String nome) {
        TimeDto timeRetorno = null;
        for (TimeDto time: BancoDados.times) {
            if (time.getNome().equalsIgnoreCase(nome)) {
                timeRetorno = time;
            }
        }
        if (timeRetorno == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(timeRetorno);
    }

    @PostMapping
    public ResponseEntity<TimeDto> cadastrarTime(@RequestBody TimeDto time) {
        time.setId(id);
        BancoDados.times.add(time);
        criarLinks(time);
        id++;
        return ResponseEntity.status(HttpStatus.CREATED).body(time);
    }

    @GetMapping
    public ResponseEntity<List<TimeDto>> listarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(BancoDados.times);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeDto> buscarPorId(@PathVariable Integer id) {
        TimeDto timeRetorno = TimeService.buscarPorId(id);
        if (timeRetorno == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(timeRetorno);
    }

    @DeleteMapping
    public ResponseEntity<TimeDto> excluir(@PathVariable Integer id) {
        TimeDto timeExcluir = TimeService.buscarPorId(id);
        if (timeExcluir == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            BancoDados.times.remove(timeExcluir);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping
    public ResponseEntity<TimeDto> alterar(@PathVariable Integer id, @RequestBody TimeDto time) {
        TimeDto timeAlterar = TimeService.buscarPorId(id);
        if (timeAlterar == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            timeAlterar.setNome(time.getNome());
            return new ResponseEntity<>(timeAlterar, HttpStatus.OK);
        }
    }

    private void criarLinks(TimeDto time) {
        time.addLink(new LinkDto("Buscar por ID", "/times/"+time.getId(), "GET"));
        time.addLink(new LinkDto("Buscar por nome", "/times/query?nome="+time.getNome(), "GET"));
        time.addLink(new LinkDto("Alterar", "/times/"+time.getId(), "PUT"));
        time.addLink(new LinkDto("Excluir", "/times/"+time.getId(), "DELETE"));
    }
}
