package br.com.senai.jpa.controller;

import br.com.senai.jpa.dto.AlunoDto;
import br.com.senai.jpa.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @PostMapping
    public ResponseEntity<AlunoDto> criar(@RequestBody AlunoDto aluno) {
        AlunoDto salvo = service.salvar(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<AlunoDto> buscarPorId(@PathVariable Long id) {
        AlunoDto aluno = service.buscarPorId(id);
        if(aluno == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(aluno);
    }


    @GetMapping
    public ResponseEntity<List<AlunoDto>> buscarTodos() {
        List<AlunoDto> alunos = service.buscarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(alunos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoDto> atualizar(@PathVariable Long id, @RequestBody AlunoDto aluno) {
        AlunoDto alunoBusca = service.buscarPorId(id);
        if (alunoBusca == null) {
            return ResponseEntity.notFound().build();
        } else {
            aluno.setId(id);
            return ResponseEntity.ok(service.salvar(aluno));
        }
    }

    @DeleteMapping
    public ResponseEntity<AlunoDto> deletar(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }


}
