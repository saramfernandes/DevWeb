package br.com.senai.jpa.dto.mapper;

import br.com.senai.jpa.dto.PessoaDto;
import br.com.senai.jpa.model.Documento;
import br.com.senai.jpa.model.Pessoa;

public class PessoaMapper {

    public static PessoaDto toDto(Pessoa pessoa){
        if (pessoa == null){
            return null;
        }
        return new PessoaDto(
                pessoa.getId(),
                pessoa.getNome(),
                pessoa.getEmail(),
                pessoa.getDataNascimento(),
                pessoa.getDocumento().getCpf(),
                pessoa.getDocumento().getRg()
        );
    }

    public static Pessoa toEntity(PessoaDto pessoaDto){
        if (pessoaDto == null){
            return null;
        }
        Pessoa pessoa = new Pessoa();
        pessoa.setId(pessoaDto.getId());
        pessoa.setNome(pessoaDto.getNome());
        pessoa.setDataNascimento(pessoaDto.getDataNascimento());
        pessoa.setEmail(pessoaDto.getEmail());

        Documento documento = new Documento();
        documento.setCpf(pessoaDto.getCpf());
        documento.setRg(pessoaDto.getRg());
        documento.setPessoa(pessoa);

        pessoa.setDocumento(documento);

        return pessoa;
    }

}
