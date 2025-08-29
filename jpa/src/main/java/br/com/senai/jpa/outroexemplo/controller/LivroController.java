package br.com.senai.jpa.controller;

import br.com.senai.jpa.dto.AutorDto;
import br.com.senai.jpa.dto.LivroDto;
import br.com.senai.jpa.model.Autor;
import br.com.senai.jpa.service.AutorService;
import br.com.senai.jpa.service.LivroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;
    private final AutorService autorService;

    public LivroController(LivroService livroService, AutorService autorService) {
        this.livroService = livroService;
        this.autorService = autorService;
    }

    @PostMapping
    public ResponseEntity<LivroDto> criar(@RequestBody LivroDto livroDto) {
        Optional<AutorDto> autorDto = autorService.buscarPorId(livroDto.getAutor().getId());
        if (autorDto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        LivroDto salvo = livroService.salvar(livroDto);
        salvo.setAutor(autorDto.get());
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public List<LivroDto> listar() {
        return livroService.listarTodos();
    }

    @GetMapping("/{id}")
    public LivroDto buscarPorId(@PathVariable Long id) {
        return livroService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        livroService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/autor/{id}")
    public ResponseEntity<List<LivroDto>> buscarPorAutor(@PathVariable Long id) {
        Optional<AutorDto> autorEncontrado = autorService.buscarPorId(id);
        if (autorEncontrado.isPresent()) {
            List<LivroDto> livroDtos = livroService.buscarPorAutor(autorEncontrado.get());
            return ResponseEntity.status(HttpStatus.CREATED).body(livroDtos);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroDto> atualizar(
            @PathVariable Long id,
            @RequestBody LivroDto livroDto
    ) {
        LivroDto livroBuscado = livroService.buscarPorId(id);
        if (livroBuscado == null) {
            return ResponseEntity.notFound().build();
        } else {
            livroDto.setId(id);
            return ResponseEntity.ok(livroService.salvar(livroDto));
        }
    }

}
