package br.com.senai.jpa.dto.mapper;

import br.com.senai.jpa.dto.DocumentoDto;
import br.com.senai.jpa.model.Documento;

public class DocumentoMapper {

    public static DocumentoDto toDTO(Documento entity) {
        if (entity == null) return null;
        return new DocumentoDto(
                entity.getId(),
                entity.getCpf(),
                entity.getRg()
        );
    }

    public static Documento toEntity(DocumentoDto dto) {
        if (dto == null) return null;
        Documento documento = new Documento();
        documento.setId(dto.getId());
        documento.setCpf(dto.getCpf());
        documento.setRg(dto.getRg());
        return documento;
    }
}
