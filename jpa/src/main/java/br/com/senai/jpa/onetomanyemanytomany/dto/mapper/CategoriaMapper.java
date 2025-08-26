package br.com.senai.jpa.onetomanyemanytomany.dto.mapper;

import br.com.senai.jpa.onetomanyemanytomany.dto.CategoriaDto;
import br.com.senai.jpa.onetomanyemanytomany.model.Categoria;

public class CategoriaMapper {

    public static CategoriaDto toDto(Categoria categoria) {
        if (categoria == null) return null;
        return new CategoriaDto(
                categoria.getId(),
                categoria.getNome(),
                categoria.getDescricao()
        );
    }

    public static Categoria toEntity(CategoriaDto categoriaDto) {
        if (categoriaDto == null) return null;
        Categoria categoria = new Categoria();
        categoria.setId(categoriaDto.getId());
        categoria.setNome(categoriaDto.getNome());
        categoria.setDescricao(categoriaDto.getDescricao());
        return categoria;
    }
}
