package br.com.senai.jpa.service;

import br.com.senai.jpa.dto.AlunoCursoDto;
import br.com.senai.jpa.dto.AlunoDto;
import br.com.senai.jpa.dto.CursoDto;
import br.com.senai.jpa.dto.mapper.AlunoCursoMapper;
import br.com.senai.jpa.dto.mapper.AlunoMapper;
import br.com.senai.jpa.dto.mapper.CursoMapper;
import br.com.senai.jpa.model.Aluno;
import br.com.senai.jpa.model.AlunoCurso;
import br.com.senai.jpa.model.Curso;
import br.com.senai.jpa.repository.AlunoCursoRepository;
import br.com.senai.jpa.repository.AlunoRepository;
import br.com.senai.jpa.repository.CursoRepository;
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

    public List<AlunoCursoDto> buscarPorAluno(AlunoDto alunoDto) {
        List<AlunoCurso> lista = alunoCursoRepository
                .findByAluno(AlunoMapper.toEntity(alunoDto));
        return lista.stream().map(AlunoCursoMapper::toDto).toList();
    }

    public List<AlunoCursoDto> buscarPorCurso(CursoDto cursoDto) {
        List<AlunoCurso> lista = alunoCursoRepository
                .findByCurso(CursoMapper.toEntity(cursoDto));
        return lista.stream().map(AlunoCursoMapper::toDto).toList();
    }

    public AlunoCursoDto salvar(AlunoCursoDto dto) {
        AlunoCurso entity = AlunoCursoMapper.toEntity(dto);

        Aluno aluno = alunoRepository.findById(dto.getIdAluno()).orElse(null);
        Curso curso = cursoRepository.findById(dto.getIdCurso()).orElse(null);
        entity.setAluno(aluno);
        entity.setCurso(curso);

        AlunoCurso matricula = alunoCursoRepository.save(entity);

        return AlunoCursoMapper.toDto(matricula);
    }

}
