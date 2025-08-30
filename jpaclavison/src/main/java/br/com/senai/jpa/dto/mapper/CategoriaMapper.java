package br.com.senai.jpa.dto.mapper;

import br.com.senai.jpa.dto.CategoriaDto;
import br.com.senai.jpa.model.Categoria;

public class CategoriaMapper {

    public static CategoriaDto toDto(Categoria categoria) {
        if (categoria == null) return null;
        return new CategoriaDto(
                categoria.getId(),
                categoria.getNome(),
                categoria.getDescricao());
    }

    public static Categoria toEntity(CategoriaDto dto) {
        if(dto == null) return null;
        Categoria categoria = new Categoria();
        categoria.setId(dto.getId());
        categoria.setNome(dto.getNome());
        categoria.setDescricao(dto.getDescricao());
        return categoria;
    }
}
