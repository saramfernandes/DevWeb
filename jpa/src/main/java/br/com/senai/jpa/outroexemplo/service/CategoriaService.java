package br.com.senai.jpa.service;

import br.com.senai.jpa.dto.CategoriaDto;
import br.com.senai.jpa.dto.mapper.CategoriaMapper;
import br.com.senai.jpa.model.Categoria;
import br.com.senai.jpa.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public CategoriaDto salvar(CategoriaDto categoriaDto) {
        Categoria categoria = categoriaRepository.save(CategoriaMapper.toEntity(categoriaDto));
        return CategoriaMapper.toDto(categoria);
    }

    public List<CategoriaDto> buscarTodos() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias.stream().map(CategoriaMapper::toDto).toList();
    }

    public Optional<CategoriaDto> buscarPorId(Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.map(CategoriaMapper::toDto);
    }

    public void excluir(Long id) {
        categoriaRepository.deleteById(id);
    }

}
