package br.com.senai.funcionario.service;

import br.com.senai.funcionario.dto.FuncionarioDto;
import br.com.senai.funcionario.dto.mapper.FuncionarioMapper;
import br.com.senai.funcionario.model.Funcionario;
import br.com.senai.funcionario.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public FuncionarioDto salvar(FuncionarioDto dto) {
        Funcionario funcionario = FuncionarioMapper.toEntity(dto);
        Funcionario salvo = repository.save(funcionario);
        return FuncionarioMapper.toDto(salvo);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public FuncionarioDto buscarPorId(Long id) {
        Funcionario funcionario = repository.findById(id).get();
        return FuncionarioMapper.toDto(funcionario);
    }

    public List<FuncionarioDto> buscarTodos() {
        List<Funcionario> funcionarios = repository.findAll();
        return funcionarios.stream().map(FuncionarioMapper::toDto).toList();
    }

}
