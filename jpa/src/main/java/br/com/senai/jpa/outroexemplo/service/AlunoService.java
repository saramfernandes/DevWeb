package br.com.senai.jpa.service;

import br.com.senai.jpa.dto.AlunoDto;
import br.com.senai.jpa.dto.mapper.AlunoMapper;
import br.com.senai.jpa.model.Aluno;
import br.com.senai.jpa.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

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

    public Optional<AlunoDto> buscarPorId(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        return aluno.map(AlunoMapper::toDto);
    }

    public void excluir(Long id) {
        alunoRepository.deleteById(id);
    }

}
