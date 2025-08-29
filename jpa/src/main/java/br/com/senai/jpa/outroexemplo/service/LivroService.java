package br.com.senai.jpa.service;

import br.com.senai.jpa.dto.AutorDto;
import br.com.senai.jpa.dto.LivroDto;
import br.com.senai.jpa.dto.mapper.AutorMapper;
import br.com.senai.jpa.dto.mapper.LivroMapper;
import br.com.senai.jpa.model.Livro;
import br.com.senai.jpa.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public LivroDto salvar(LivroDto livroDto) {
        Livro livroSalvo = livroRepository.save(LivroMapper.toEntity(livroDto));
        return LivroMapper.toDto(livroSalvo);
    }

    public List<LivroDto> listarTodos() {
        List<Livro> livros = livroRepository.findAll();
        return livros.stream().map(LivroMapper::toDto).toList();
    }

    public LivroDto buscarPorId(Long id) {
        Livro livro = livroRepository.findById(id).get();
        return LivroMapper.toDto(livro);
    }

    public void excluir(Long id) {
        livroRepository.deleteById(id);
    }

    public List<LivroDto> buscarPorAutor(AutorDto autor) {
        List<Livro> livros = livroRepository.findByAutor(AutorMapper.toEntity(autor));
        return livros.stream().map(LivroMapper::toDto).toList();
    }

}
