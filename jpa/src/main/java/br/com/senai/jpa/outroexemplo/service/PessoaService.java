package br.com.senai.jpa.service;

import br.com.senai.jpa.dto.PessoaDto;
import br.com.senai.jpa.dto.mapper.PessoaMapper;
import br.com.senai.jpa.model.Pessoa;
import br.com.senai.jpa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaDto salvar(PessoaDto pessoaDto){
        Pessoa pessoaSalva = pessoaRepository.save(PessoaMapper.toEntity(pessoaDto));
        return PessoaMapper.toDto(pessoaSalva);
    }

    public List<PessoaDto> listarTodas() {
        List<Pessoa> pessoasEntity = pessoaRepository.findAll();
        List<PessoaDto> dtos = new ArrayList<>();
        for (Pessoa pessoa : pessoasEntity) {
            dtos.add(PessoaMapper.toDto(pessoa));
        }
        return dtos;
    }

    public Optional<PessoaDto> buscarPorId(Long id) {
        return pessoaRepository.findById(id).map(PessoaMapper::toDto);
    }

    public void excluir(Long id) {
        pessoaRepository.deleteById(id);
    }

    public List<PessoaDto> buscarPorNome(String nome) {
        List<Pessoa> pessoasEntity = pessoaRepository.findByNomeLike("%" + nome + "%");
        List<PessoaDto> dtos = new ArrayList<>();
        for (Pessoa pessoa : pessoasEntity) {
            dtos.add(PessoaMapper.toDto(pessoa));
        }
        return dtos;
    }

    public List<PessoaDto> buscarPorDataNascimentoAntes(LocalDate data) {
        List<Pessoa> pessoasEntity = pessoaRepository.findPessoasNascidasAntesDe(data);
        List<PessoaDto> dtos = new ArrayList<>();
        for (Pessoa pessoa : pessoasEntity) {
            dtos.add(PessoaMapper.toDto(pessoa));
        }
        return dtos;
    }

    public PessoaDto buscarPorCpfDoDocumento(String cpf) {
        return PessoaMapper.toDto(pessoaRepository.findByCpfDoDocumento(cpf));
    }

    public PessoaDto buscarPorEmail(String email) {
        return PessoaMapper.toDto(pessoaRepository.findByEmail(email));
    }

}
