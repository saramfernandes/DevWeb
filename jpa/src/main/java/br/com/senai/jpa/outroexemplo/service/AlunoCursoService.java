package br.com.senai.jpa.outroexemplo.service;

import br.com.senai.jpa.outroexemplo.dto.AlunoCursoDto;
import br.com.senai.jpa.outroexemplo.dto.AlunoDto;
import br.com.senai.jpa.outroexemplo.dto.CursoDto;
import br.com.senai.jpa.outroexemplo.dto.mapper.AlunoCursoMapper;
import br.com.senai.jpa.outroexemplo.dto.mapper.AlunoMapper;
import br.com.senai.jpa.outroexemplo.dto.mapper.CursoMapper;
import br.com.senai.jpa.outroexemplo.model.Aluno;
import br.com.senai.jpa.outroexemplo.model.AlunoCurso;
import br.com.senai.jpa.outroexemplo.model.Curso;
import br.com.senai.jpa.outroexemplo.repository.AlunoCursoRepository;
import br.com.senai.jpa.outroexemplo.repository.AlunoRepository;
import br.com.senai.jpa.outroexemplo.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoCursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private AlunoCursoRepository alunoCursoRepository;

    public AlunoCursoDto salvar(AlunoCursoDto alunoCursoDto) {
        AlunoCurso entity = new AlunoCursoMapper().toEntity(alunoCursoDto);

        Aluno aluno = alunoRepository.findById(alunoCursoDto.getIdAluno()).orElse(null);
        Curso curso = cursoRepository.findById(alunoCursoDto.getIdCurso()).orElse(null);
        entity.setAluno(aluno);
        entity.setCurso(curso);

        AlunoCurso matricula = alunoCursoRepository.save(entity);

        return AlunoCursoMapper.toDto(matricula);
    }

    public List<AlunoCursoDto> buscarPorAluno(AlunoDto alunoDto) {
        List<AlunoCurso> lista = alunoCursoRepository.findByAluno(AlunoMapper.toEntity(alunoDto));
        return lista.stream().map(AlunoCursoMapper::toDto).toList();
    }

    public List<AlunoCursoDto> buscarPorCurso(CursoDto cursoDto) {
        List<AlunoCurso> lista = alunoCursoRepository.findByCurso(CursoMapper.toEntity(cursoDto));
        return lista.stream().map(AlunoCursoMapper::toDto).toList();
    }


}
