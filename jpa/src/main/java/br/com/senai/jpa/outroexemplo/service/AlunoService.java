package br.com.senai.jpa.outroexemplo.service;


import br.com.senai.jpa.outroexemplo.dto.AlunoDto;
import br.com.senai.jpa.outroexemplo.dto.mapper.AlunoMapper;
import br.com.senai.jpa.outroexemplo.model.Aluno;
import br.com.senai.jpa.outroexemplo.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public AlunoDto salvar(AlunoDto alunoDto) {
        Aluno aluno = alunoRepository.save(AlunoMapper.toEntity(alunoDto));
        return AlunoMapper.toDto(aluno);
    }

    public List<AlunoDto> buscarTodos() {
        List<Aluno> alunos = alunoRepository.findAll();
        return alunos.stream().map(AlunoMapper::toDto).toList();
    }

    public AlunoDto buscarPorId(Long id) {
        Aluno aluno = alunoRepository.findById(id).get();
        return AlunoMapper.toDto(aluno);
    }

    public void excluir(Long id) {
        alunoRepository.deleteById(id);
    }

}
