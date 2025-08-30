package br.com.senai.jpa.service;

import br.com.senai.jpa.dto.CursoDto;
import br.com.senai.jpa.dto.mapper.CursoMapper;
import br.com.senai.jpa.model.Curso;
import br.com.senai.jpa.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {
    @Autowired
    private CursoRepository repository;

    public CursoDto salvar(CursoDto dto) {
        Curso curso = CursoMapper.toEntity(dto);
        Curso cursoSaved = repository.save(curso);
        return CursoMapper.toDto(cursoSaved);
    }

    public void delete(CursoDto dto) {
        Curso curso = CursoMapper.toEntity(dto);
        repository.delete(curso);
    }

    public CursoDto buscarPorId(Long id) {
        Curso curso = repository.findById(id).get();
        return CursoMapper.toDto(curso);
    }

    public List<CursoDto> buscarTodos() {
        List<Curso> cursos = repository.findAll();
        return cursos.stream().map(CursoMapper::toDto).toList();
    }

    public void deletar (Long id) {
        repository.deleteById(id);
    }
}
