package com.erp.funcionariocargo.domains.funcionario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @PostMapping
    public ResponseEntity<FuncionarioDTO> criar(@RequestBody FuncionarioDTO funcionario) {
        FuncionarioDTO salvo = service.salvar(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> buscarPorId(@PathVariable Long id) {
        FuncionarioDTO funcionario = service.buscarPorId(id);
        if (funcionario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(funcionario);
    }

    @GetMapping
    public Page<Funcionario> getFuncionarios(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size) {
        return service.getFuncionariosPaginados(page, size);
    }

    @GetMapping("/salario")
    public ResponseEntity<List<FuncionarioDTO>> buscarPorSalarioBetween(
            @RequestParam Double salarioMin, 
            @RequestParam Double salarioMax) {
        List<FuncionarioDTO> funcionarios = service.buscarPorSalarioBetween(salarioMin, salarioMax);
        return ResponseEntity.ok(funcionarios);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> atualizar(@PathVariable Long id, @RequestBody FuncionarioDTO funcionario) {
        FuncionarioDTO funcionarioBusca = service.buscarPorId(id);
        if (funcionarioBusca == null) {
            return ResponseEntity.notFound().build();
        } else {
            funcionario.setId(id);
            return ResponseEntity.ok(service.salvar(funcionario));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
