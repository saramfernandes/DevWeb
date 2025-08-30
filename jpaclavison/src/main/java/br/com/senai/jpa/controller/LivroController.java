package br.com.senai.jpa.controller;

import br.com.senai.jpa.dto.AutorDto;
import br.com.senai.jpa.dto.LivroDto;
import br.com.senai.jpa.service.AutorService;
import br.com.senai.jpa.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    LivroService service;

    @Autowired
    AutorService autorService;

    @PostMapping
    public ResponseEntity<LivroDto> criar(@RequestBody LivroDto livroDto) {
        AutorDto autorDto = autorService.buscarPorId(livroDto.getAutor().getId());
        if (autorDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        LivroDto salvo = service.salvar(livroDto);
        salvo.setAutor(autorDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroDto> atualizar(@PathVariable Long id, @RequestBody LivroDto livroDto) {
        LivroDto livroBuscado = service.buscarPorId(id);
        if(livroBuscado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else{
            livroDto.setId(id);
            return ResponseEntity.ok(service.salvar(livroDto));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<LivroDto>> listar() {
        List<LivroDto> lista = service.buscarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDto> buscarPorId(@PathVariable Long id) {
        LivroDto livroDto = service.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(livroDto);
    }

    @GetMapping("/autor/{id}")
    public ResponseEntity<List<LivroDto>> buscarPorAutor(@PathVariable Long id) {
        AutorDto autorDto = autorService.buscarPorId(id);
        if(autorDto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        List<LivroDto> lista = service.buscarPorAutor(autorDto);
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }



}
