package br.com.senai.jpa.onetomany.dto.mapper;

import br.com.senai.jpa.onetomany.dto.AutorDto;
import br.com.senai.jpa.onetomany.model.Autor;

public class AutorMapper {

    public static AutorDto toDto(Autor autor) {
        if (autor == null) return null;
        return new AutorDto(
                autor.getId(),
                autor.getNome(),
                autor.getNacionalidade(),
                autor.getDataNascimento()
        );
    }

    public static Autor toEntity(AutorDto autorDto) {
        if (autorDto == null) return null;
        Autor autor = new Autor();
        autor.setId(autorDto.getId());
        autor.setNome(autorDto.getNome());
        autor.setNacionalidade(autorDto.getNacionalidade());
        autor.setDataNascimento(autorDto.getDataNascimento());
        return autor;
    }
}
