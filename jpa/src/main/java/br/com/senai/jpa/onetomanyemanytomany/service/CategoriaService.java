package br.com.senai.jpa.onetomanyemanytomany.service;

import br.com.senai.jpa.onetomanyemanytomany.dto.CategoriaDto;
import br.com.senai.jpa.onetomanyemanytomany.dto.mapper.CategoriaMapper;
import br.com.senai.jpa.onetomanyemanytomany.model.Categoria;
import br.com.senai.jpa.onetomanyemanytomany.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public CategoriaDto salvar(CategoriaDto categoriaDto) {
        Categoria categoria = CategoriaMapper.toEntity(categoriaDto);
        Categoria categoriaSalva = repository.save(categoria);
        return CategoriaMapper.toDto(categoriaSalva);
    }

    public void excluir(Long id) {
        repository.findById(id).get();
    }

    public CategoriaDto buscarPorId(long id) {
        Categoria categoria =  repository.findById(id).get();
        return CategoriaMapper.toDto(categoria);
    }

    public List<CategoriaDto> buscarTodos() {
        return repository.findAll().stream().map(CategoriaMapper::toDto).toList();
    }

}
