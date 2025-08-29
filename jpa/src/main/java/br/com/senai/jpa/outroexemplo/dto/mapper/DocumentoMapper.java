package br.com.senai.jpa.dto.mapper;

import br.com.senai.jpa.dto.DocumentoDto;
import br.com.senai.jpa.model.Documento;

public class DocumentoMapper {

    public static DocumentoDto toDto(Documento documento){
        if (documento == null){
            return null;
        }
        return new DocumentoDto(
            documento.getId(),
            documento.getCpf(),
            documento.getRg()
        );
    }

    public static Documento toEntity(DocumentoDto documentoDto){
        if (documentoDto == null){
            return null;
        }
        Documento documento = new Documento();
        documento.setId(documentoDto.getId());
        documento.setCpf(documentoDto.getCpf());
        documento.setRg(documentoDto.getRg());
        return documento;
    }

}
