package br.com.senai.jpa.service;

import br.com.senai.jpa.dto.AlunoDto;
import br.com.senai.jpa.dto.CursoDto;
import br.com.senai.jpa.dto.mapper.AlunoMapper;
import br.com.senai.jpa.dto.mapper.CursoMapper;
import br.com.senai.jpa.model.Aluno;
import br.com.senai.jpa.model.Curso;
import br.com.senai.jpa.repository.AlunoRepository;
import br.com.senai.jpa.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public CursoDto salvar(CursoDto cursoDto) {
        Curso curso = cursoRepository.save(CursoMapper.toEntity(cursoDto));
        return CursoMapper.toDto(curso);
    }

    public List<CursoDto> buscarTodos() {
        List<Curso> cursos = cursoRepository.findAll();
        return cursos.stream().map(CursoMapper::toDto).toList();
    }

    public Optional<CursoDto> buscarPorId(Long id) {
        Optional<Curso> curso = cursoRepository.findById(id);
        return curso.map(CursoMapper::toDto);
    }

    public void excluir(Long id) {
        cursoRepository.deleteById(id);
    }

}
