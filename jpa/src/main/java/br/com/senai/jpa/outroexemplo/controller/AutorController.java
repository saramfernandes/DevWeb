package br.com.senai.jpa.controller;

import br.com.senai.jpa.dto.AutorDto;
import br.com.senai.jpa.service.AutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @PostMapping
    public ResponseEntity<AutorDto> criar(@RequestBody AutorDto autorDto) {
        AutorDto salva = autorService.salvar(autorDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salva);
    }

    @GetMapping
    public ResponseEntity<List<AutorDto>> listar() {
        List<AutorDto> lista = autorService.listarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorDto> buscarPorId(@PathVariable Long id) {
        return autorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        autorService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorDto> atualizar(
            @PathVariable Long id,
            @RequestBody AutorDto autorDto
    ) {
        Optional<AutorDto> autorBusca = autorService.buscarPorId(id);
        if (autorBusca.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            autorDto.setId(id);
            return ResponseEntity.ok(autorService.salvar(autorDto));
        }
    }

}
