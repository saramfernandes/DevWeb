package br.com.senai.jpa.outroexemplo.controller;

import br.com.senai.jpa.outroexemplo.dto.AlunoCursoDto;
import br.com.senai.jpa.outroexemplo.dto.AlunoDto;
import br.com.senai.jpa.outroexemplo.dto.CursoDto;
import br.com.senai.jpa.outroexemplo.service.AlunoCursoService;
import br.com.senai.jpa.outroexemplo.service.AlunoService;
import br.com.senai.jpa.outroexemplo.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        if (alunoDto == null || cursoDto == null) {
            return ResponseEntity.notFound().build();
        }
        AlunoCursoDto salvo = alunoCursoService.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

}
