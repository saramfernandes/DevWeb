package br.com.senai.jpa.outroexemplo.service;

import br.com.senai.jpa.outroexemplo.dto.CursoDto;
import br.com.senai.jpa.outroexemplo.dto.mapper.CursoMapper;
import br.com.senai.jpa.outroexemplo.model.Curso;
import br.com.senai.jpa.outroexemplo.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

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

    public CursoDto buscarPorId(Long id) {
        Curso curso = cursoRepository.findById(id).get();
        return CursoMapper.toDto(curso);
    }

    public void excluir(Long id) {
        cursoRepository.deleteById(id);
    }

}
