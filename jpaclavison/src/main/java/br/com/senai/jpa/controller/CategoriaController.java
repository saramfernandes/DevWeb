package br.com.senai.jpa.controller;

import br.com.senai.jpa.dto.CategoriaDto;
import br.com.senai.jpa.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @PostMapping
    public ResponseEntity<CategoriaDto> criar(@RequestBody CategoriaDto categoria) {
        CategoriaDto salvo = service.salvar(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDto> atualizar(@PathVariable Long id, @RequestBody CategoriaDto categoria) {
        CategoriaDto catBusca = service.buscarPorId(id);
        if (catBusca == null) {
            return ResponseEntity.notFound().build();
        } else {
            categoria.setId(id);
            return ResponseEntity.ok(service.salvar(categoria));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluirPorId(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDto>> listar() {
        List<CategoriaDto> lista = service.listar();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDto> buscarPorId(@PathVariable Long id) {
        CategoriaDto categoriaDto = service.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(categoriaDto);
    }

}
