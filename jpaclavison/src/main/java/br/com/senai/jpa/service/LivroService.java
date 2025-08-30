package br.com.senai.jpa.service;

import br.com.senai.jpa.dto.AutorDto;
import br.com.senai.jpa.dto.LivroDto;
import br.com.senai.jpa.dto.mapper.AutorMapper;
import br.com.senai.jpa.dto.mapper.LivroMapper;
import br.com.senai.jpa.model.Autor;
import br.com.senai.jpa.model.Livro;
import br.com.senai.jpa.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    public LivroDto salvar (LivroDto livroDto) {
        Livro livro = LivroMapper.toEntity(livroDto);
        Livro livroSalvo = repository.save(livro);
        return LivroMapper.toDto(livroSalvo);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public LivroDto buscarPorId(Long id) {
        Livro livro = repository.findById(id).get();
        return LivroMapper.toDto(livro);
    }

    public List<LivroDto> buscarTodos() {
        List<Livro> livros = repository.findAll();
        return livros.stream().map(LivroMapper::toDto).toList();
    }
    public List<LivroDto> buscarPorAutor(AutorDto autorDto) {
        Autor autor = AutorMapper.toEntity(autorDto);
        List<Livro> livros = repository.findByAutor(autor);
        return livros.stream().map(LivroMapper::toDto).toList();
    }

}
