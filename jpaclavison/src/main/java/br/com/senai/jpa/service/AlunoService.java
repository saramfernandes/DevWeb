package br.com.senai.jpa.service;

import br.com.senai.jpa.dto.AlunoDto;
import br.com.senai.jpa.dto.mapper.AlunoMapper;
import br.com.senai.jpa.model.Aluno;
import br.com.senai.jpa.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository repository;

    public AlunoDto salvar(AlunoDto dto) {
        Aluno aluno = AlunoMapper.toEntity(dto);
        Aluno salvo = repository.save(aluno);
        return AlunoMapper.toDto(salvo);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public AlunoDto buscarPorId(Long id) {
        Aluno aluno = repository.findById(id).get();
        return AlunoMapper.toDto(aluno);
    }

    public List<AlunoDto> buscarTodos() {
        List<Aluno> alunos = repository.findAll();
        return alunos.stream().map(AlunoMapper::toDto).toList();
    }
}
