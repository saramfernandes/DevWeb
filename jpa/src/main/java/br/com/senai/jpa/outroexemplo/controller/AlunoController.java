package br.com.senai.jpa.outroexemplo.controller;


import br.com.senai.jpa.outroexemplo.dto.AlunoDto;
import br.com.senai.jpa.outroexemplo.service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public ResponseEntity<AlunoDto> criar(@RequestBody AlunoDto alunoDto) {
        AlunoDto salvo = alunoService.salvar(alunoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public ResponseEntity<List<AlunoDto>> listar() {
        List<AlunoDto> lista = alunoService.buscarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDto> buscarPorId(@PathVariable Long id) {
        return alunoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        alunoService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoDto> atualizar(
            @PathVariable Long id,
            @RequestBody AlunoDto alunoDto
    ) {
        Optional<AlunoDto> alunoBusca = alunoService.buscarPorId(id);
        if (alunoBusca.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            alunoDto.setId(id);
            return ResponseEntity.ok(alunoService.salvar(alunoDto));
        }
    }

}
