package br.com.senai.jpa.onetomanyemanytomany.controller;

import br.com.senai.jpa.onetomanyemanytomany.dto.AutorDto;
import br.com.senai.jpa.onetomanyemanytomany.dto.LivroDto;
import br.com.senai.jpa.onetomanyemanytomany.service.AutorService;
import br.com.senai.jpa.onetomanyemanytomany.service.LivroService;
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
        if (autorDto==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        LivroDto salvo = service.salvar(livroDto);
        salvo.setAutor(autorDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroDto> atualizar(@PathVariable Long id, @RequestBody LivroDto livroDto) {
        LivroDto livroBusca = service.buscarPorId(id);
        if (livroBusca == null) return ResponseEntity.notFound().build();
        livroDto.setId(id);
        return ResponseEntity.ok(service.salvar(livroDto));
    }

    @GetMapping
    public ResponseEntity<List<LivroDto>> listarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/autor/{id}")
    public ResponseEntity<List<LivroDto>> buscarPorAutor(@PathVariable Long id) {
        AutorDto autorDto = autorService.buscarPorId(id);
        if (autorDto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        List<LivroDto> lista = service.buscarPorAutor(autorDto);
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }


}
