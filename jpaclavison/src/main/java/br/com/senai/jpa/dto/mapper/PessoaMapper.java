package br.com.senai.jpa.dto.mapper;

import br.com.senai.jpa.dto.PessoaDto;
import br.com.senai.jpa.model.Documento;
import br.com.senai.jpa.model.Pessoa;

public class PessoaMapper {

    public static PessoaDto toDTO(Pessoa entity) {
        if (entity == null) return null;
        return new PessoaDto(
                entity.getId(),
                entity.getNome(),
                entity.getEmail(),
                entity.getDataNascimento(),
                entity.getDocumento().getCpf(),
                entity.getDocumento().getRg()
        );
    }

    public static Pessoa toEntity(PessoaDto dto) {
        if (dto == null) return null;
        Pessoa pessoa = new Pessoa();
        pessoa.setId(dto.getId());
        pessoa.setNome(dto.getNome());
        pessoa.setEmail(dto.getEmail());
        pessoa.setDataNascimento(dto.getDataNascimento());
        Documento documento = new Documento();
        documento.setCpf(dto.getCpf());
        documento.setRg(dto.getRg());
        if (documento != null) {
            documento.setPessoa(pessoa);
        }
        pessoa.setDocumento(documento);
        return pessoa;
    }
}
