package br.com.senai.jpa.service;

import br.com.senai.jpa.dto.AutorDto;
import br.com.senai.jpa.dto.mapper.AutorMapper;
import br.com.senai.jpa.model.Autor;
import br.com.senai.jpa.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutorService {

    private final AutorRepository repository;

    public AutorService(AutorRepository repository) {
        this.repository = repository;
    }

    public AutorDto salvar (AutorDto autorDto) {
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
        List<Autor> autores = repository.findAll();
       /*
       List<AutorDto> dtos = new ArrayList<>();
        for (Autor autor : autores) {
            dtos.add(AutorMapper.toDto(autor));
        }
        return dtos;
        */
        return autores.stream().map(AutorMapper::toDto).toList();
    }


}
