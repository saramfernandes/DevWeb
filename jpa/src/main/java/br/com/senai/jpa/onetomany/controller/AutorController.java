package br.com.senai.jpa.onetomany.controller;

import br.com.senai.jpa.onetomany.dto.AutorDto;
import br.com.senai.jpa.onetomany.service.AutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorService service;

    public AutorController(AutorService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AutorDto> criar(@RequestBody AutorDto autor) {
        AutorDto salvo = service.salvar(autor);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorDto> atualizar(@PathVariable Long id, @RequestBody AutorDto autor) {
        AutorDto autorBusca = service.buscarPorId(id);
        if (autorBusca == null) return ResponseEntity.notFound().build();

        autor.setId(id);
        return ResponseEntity.ok(service.salvar(autor));
    }

    @GetMapping
    public ResponseEntity<List<AutorDto>> listarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
