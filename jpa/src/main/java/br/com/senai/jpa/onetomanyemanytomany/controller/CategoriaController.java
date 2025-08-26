package br.com.senai.jpa.onetomanyemanytomany.controller;

import br.com.senai.jpa.onetomanyemanytomany.dto.CategoriaDto;
import br.com.senai.jpa.onetomanyemanytomany.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CategoriaService service;

    @PostMapping
    public ResponseEntity<CategoriaDto> criar(@RequestBody CategoriaDto categoriaDto) {
        if (categoriaDto==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        CategoriaDto salvo = service.salvar(categoriaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDto> atualizar(@PathVariable Long id, @RequestBody CategoriaDto categoriaDto) {
        CategoriaDto categoriaBuscar = service.buscarPorId(id);
        if (categoriaBuscar == null) return ResponseEntity.notFound().build();
        categoriaDto.setId(id);
        return ResponseEntity.ok(service.salvar(categoriaDto));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDto>> listarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
