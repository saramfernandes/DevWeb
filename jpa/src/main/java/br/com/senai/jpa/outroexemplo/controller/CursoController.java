package br.com.senai.jpa.controller;

import br.com.senai.jpa.dto.CursoDto;
import br.com.senai.jpa.service.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping
    public ResponseEntity<CursoDto> criar(@RequestBody CursoDto cursoDto) {
        CursoDto salvo = cursoService.salvar(cursoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public ResponseEntity<List<CursoDto>> listar() {
        List<CursoDto> lista = cursoService.buscarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDto> buscarPorId(@PathVariable Long id) {
        return cursoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        cursoService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoDto> atualizar(
            @PathVariable Long id,
            @RequestBody CursoDto cursoDto
    ) {
        Optional<CursoDto> cursoBusca = cursoService.buscarPorId(id);
        if (cursoBusca.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            cursoDto.setId(id);
            return ResponseEntity.ok(cursoService.salvar(cursoDto));
        }
    }

}
