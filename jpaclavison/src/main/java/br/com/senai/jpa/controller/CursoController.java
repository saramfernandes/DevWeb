package br.com.senai.jpa.controller;

import br.com.senai.jpa.dto.CursoDto;
import br.com.senai.jpa.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService service;

    @PostMapping
    public ResponseEntity<CursoDto> criar(@RequestBody CursoDto curso) {
        CursoDto salvo = service.salvar(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDto> buscarPorId(@PathVariable Long id) {
        CursoDto curso = service.buscarPorId(id);
        if(curso == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(curso);
    }


    @GetMapping
    public ResponseEntity<List<CursoDto>> buscarTodos() {
        List<CursoDto> cursos = service.buscarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(cursos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoDto> atualizar(@PathVariable Long id, @RequestBody CursoDto curso) {
        CursoDto cursoBusca = service.buscarPorId(id);
        if (cursoBusca == null)
            return ResponseEntity.notFound().build();
        curso.setId(id);
        return ResponseEntity.ok(service.salvar(curso));
    }

    @DeleteMapping
    public ResponseEntity<CursoDto> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
