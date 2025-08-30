package br.com.senai.jpa.service;

import br.com.senai.jpa.dto.CategoriaDto;
import br.com.senai.jpa.dto.mapper.CategoriaMapper;
import br.com.senai.jpa.model.Categoria;
import br.com.senai.jpa.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public CategoriaDto salvar (CategoriaDto categoriaDto) {
        Categoria categoria = CategoriaMapper.toEntity(categoriaDto);
        Categoria catSalvo = repository.save(categoria);
        return CategoriaMapper.toDto(catSalvo);
    }

    public List<CategoriaDto> listar() {
        List<Categoria> categorias = repository.findAll();
        return categorias.stream().map(CategoriaMapper::toDto).toList();
    }

    public CategoriaDto buscarPorId(Long id) {
        Categoria categoria = repository.findById(id).get();
        return CategoriaMapper.toDto(categoria);
    }

    public void  excluirPorId(Long id) {
        repository.deleteById(id);
    }

}
