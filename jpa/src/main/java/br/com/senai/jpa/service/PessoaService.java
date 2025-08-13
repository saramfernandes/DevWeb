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

    public PessoaDto salvar(PessoaDto pessoaDto) {
        Pessoa pessoa = PessoaMapper.toEntity(pessoaDto);
        Pessoa salva = pessoaRepository.save(pessoa);
        return PessoaMapper.toDto(salva);
    }

    public List<PessoaDto> listarTodas() {
        List<Pessoa> pessoaEntity = pessoaRepository.findAll();
        List<PessoaDto> dtos = new ArrayList<>();
        for (Pessoa pessoa : pessoaEntity) {
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

    public PessoaDto buscarPorEmail(String email) {
        Pessoa pessoa = pessoaRepository.findByEmail(email);
        return PessoaMapper.toDto(pessoa);
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
}
