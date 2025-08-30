package br.com.senai.jpa.dto.mapper;

import br.com.senai.jpa.dto.CategoriaDto;
import br.com.senai.jpa.dto.LivroDto;
import br.com.senai.jpa.model.Categoria;
import br.com.senai.jpa.model.Livro;

public class LivroMapper {

    public static LivroDto toDto(Livro livro) {
        return new LivroDto(
                livro.getId(),
                livro.getTitulo(),
                livro.getIsbn(),
                livro.getPaginas(),
                livro.getPreco(),
                AutorMapper.toDto(livro.getAutor()),
                livro.getCategorias().stream().map(CategoriaMapper::toDto).toList()
        );
    }
    public static Livro toEntity(LivroDto dto) {
        Livro livro = new Livro();
        livro.setId(dto.getId());
        livro.setTitulo(dto.getTitulo());
        livro.setIsbn(dto.getIsbn());
        livro.setPaginas(dto.getPaginas());
        livro.setPreco(dto.getPreco());
        livro.setAutor(AutorMapper.toEntity(dto.getAutor()));
        livro.setCategorias(dto.getCategorias().stream().map(CategoriaMapper::toEntity).toList());
        return livro;
    }
}
