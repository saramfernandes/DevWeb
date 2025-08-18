package br.com.senai.jpa.onetomany.service;

import br.com.senai.jpa.onetomany.dto.AutorDto;
import br.com.senai.jpa.onetomany.dto.mapper.AutorMapper;
import br.com.senai.jpa.onetomany.model.Autor;
import br.com.senai.jpa.onetomany.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    private final AutorRepository repository;

    public AutorService(AutorRepository repository) {
        this.repository = repository;
    }

    public AutorDto salvar(AutorDto autorDto) {
        Autor autor = AutorMapper.toEntity(autorDto);
        Autor autorNovo = repository.save(autor);
        return AutorMapper.toDto(autorNovo);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public AutorDto buscarPorId(Long id) {
        Autor autor = repository.findById(id).get();
        return AutorMapper.toDto(autor);
    }

    public List<AutorDto> buscarTodos() {
//        List<Autor> autores = repository.findAll();
//        return autores.stream().map(AutorMapper::toDto).toList();
        return repository.findAll().stream().map(AutorMapper::toDto).toList();
    }
}
