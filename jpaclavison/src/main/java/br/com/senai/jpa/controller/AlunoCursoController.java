package br.com.senai.jpa.controller;

import br.com.senai.jpa.dto.AlunoCursoDto;
import br.com.senai.jpa.dto.AlunoDto;
import br.com.senai.jpa.dto.CursoDto;
import br.com.senai.jpa.dto.mapper.AlunoMapper;
import br.com.senai.jpa.dto.mapper.CursoMapper;
import br.com.senai.jpa.service.AlunoCursoService;
import br.com.senai.jpa.service.AlunoService;
import br.com.senai.jpa.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class AlunoCursoController {

    @Autowired
    private AlunoCursoService alunoCursoService;

    @Autowired
    private CursoService cursoService;

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<AlunoCursoDto> salvar(@RequestBody AlunoCursoDto dto) {
        AlunoDto alunoDto = alunoService.buscarPorId(dto.getIdAluno());
        CursoDto cursoDto = cursoService.buscarPorId(dto.getIdCurso());
        if(alunoDto == null || cursoDto == null){
            return ResponseEntity.notFound().build();
        }
        AlunoCursoDto salvo = alunoCursoService.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping("/curso")
    public ResponseEntity<List<AlunoCursoDto>> buscarPorCurso(@RequestParam Long id) {
        CursoDto curso = cursoService.buscarPorId(id);
        if(curso == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(alunoCursoService.buscarPorCurso((curso)));
    }

    @GetMapping("/aluno")
    public ResponseEntity<List<AlunoCursoDto>> buscarPorAluno(@RequestParam Long id) {
        AlunoDto aluno = alunoService.buscarPorId(id);
        if(aluno == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(alunoCursoService.buscarPorAluno((aluno)));
    }

}
