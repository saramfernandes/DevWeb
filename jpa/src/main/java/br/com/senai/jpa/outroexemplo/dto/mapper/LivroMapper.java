package br.com.senai.jpa.dto.mapper;

import br.com.senai.jpa.dto.LivroDto;
import br.com.senai.jpa.model.Livro;

public class LivroMapper {

    public static LivroDto toDto(Livro livro) {
        if (livro == null) {
            return null;
        }
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

    public static Livro toEntity(LivroDto livroDto) {
        if (livroDto == null) {
            return null;
        }
        Livro livro = new Livro();
        livro.setId(livroDto.getId());
        livro.setTitulo(livroDto.getTitulo());
        livro.setIsbn(livroDto.getIsbn());
        livro.setPaginas(livroDto.getPaginas());
        livro.setPreco(livroDto.getPreco());
        livro.setAutor(AutorMapper.toEntity(livroDto.getAutor()));
        livro.setCategorias(livroDto.getCategoriasDto().stream().map(CategoriaMapper::toEntity).toList());
        return livro;
    }

}
