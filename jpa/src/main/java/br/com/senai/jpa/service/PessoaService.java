package br.com.senai.jpa.service;

import br.com.senai.jpa.model.Pessoa;
import br.com.senai.jpa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa salvar(Pessoa pessoa) {
        if (pessoa.getDocumento() != null) {
            pessoa.getDocumento().setPessoa(pessoa);
        }
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> listarTodas() {
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> buscarPorId(Long id) {
        return pessoaRepository.findById(id);
    }

    public void excluir(Long id) {
        pessoaRepository.deleteById(id);
    }

    public Pessoa buscarPorEmail(String email) {
        return pessoaRepository.findByEmail(email);
    }

    public List<Pessoa> buscarPorNome(String nome) {
        return pessoaRepository.findByNomeLike("%" + nome + "%");
    }

    public List<Pessoa> buscarPorDataNascimentoAntes(LocalDate data) {
        return pessoaRepository.findPessoasNascidasAntesDe(data);
    }

    public Pessoa buscarPorCpfDoDocumento(String cpf) {
        return pessoaRepository.findByCpfDoDocumento(cpf);
    }
}
