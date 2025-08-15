package br.com.senai.jpa.onetoone.controller;

import br.com.senai.jpa.onetoone.dto.PessoaDto;
import br.com.senai.jpa.onetoone.service.PessoaService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    public ResponseEntity<PessoaDto> criar(@RequestBody PessoaDto pessoa) {
        PessoaDto salva = pessoaService.salvar(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(salva);
    }

    @GetMapping
    public List<PessoaDto> listar() {
        return pessoaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDto> buscarPorId(@PathVariable Long id) {
        return pessoaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        pessoaService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/email")
    public PessoaDto buscarPorEmail(@RequestParam String email) {
        return pessoaService.buscarPorEmail(email);
    }

    @GetMapping("/nome")
    public List<PessoaDto> buscarPorNome(@RequestParam String nome) {
        return pessoaService.buscarPorNome(nome);
    }

    @GetMapping("/nascimento-anterior")
    public List<PessoaDto> buscarPorDataAnterior(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
        return pessoaService.buscarPorDataNascimentoAntes(data);
    }

    @GetMapping("/cpf")
    public PessoaDto buscarPorCpfDoDocumento(@RequestParam String cpf) {
        return pessoaService.buscarPorCpfDoDocumento(cpf);
    }
}
