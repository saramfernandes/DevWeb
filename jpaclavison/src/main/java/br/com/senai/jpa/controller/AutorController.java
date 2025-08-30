package br.com.senai.jpa.controller;

import br.com.senai.jpa.dto.AutorDto;
import br.com.senai.jpa.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorService service;

    public AutorController(AutorService service) {
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
        if (autorBusca == null) {
            return ResponseEntity.notFound().build();
        } else {
            autor.setId(id);
            return ResponseEntity.ok(service.salvar(autor));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<AutorDto>> listar() {
        List<AutorDto> lista = service.buscarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorDto> buscarPorId(@PathVariable Long id) {
        AutorDto autorDto = service.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(autorDto);
    }

}
