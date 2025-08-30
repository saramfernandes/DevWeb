package br.com.senai.jpa.outroexemplo.service;

import br.com.senai.jpa.outroexemplo.dto.AutorDto;
import br.com.senai.jpa.outroexemplo.dto.mapper.AutorMapper;
import br.com.senai.jpa.outroexemplo.model.Autor;
import br.com.senai.jpa.outroexemplo.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public AutorDto salvar(AutorDto autorDto) {
        Autor autorSalvo = autorRepository.save(AutorMapper.toEntity(autorDto));
        return AutorMapper.toDto(autorSalvo);
    }

    public List<AutorDto> listarTodos() {
        List<Autor> autores = autorRepository.findAll();
        return autores.stream().map(AutorMapper::toDto).toList();
    }

    public Optional<AutorDto> buscarPorId(Long id) {
        Optional<Autor> autor = autorRepository.findById(id);
        return autor.map(AutorMapper::toDto);
    }

    public void excluir(Long id) {
        autorRepository.deleteById(id);
    }

}
