package br.com.senai.jpa.controller;


import br.com.senai.jpa.dto.DocumentoDto;
import br.com.senai.jpa.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/documentos")
public class DocumentoController {

    @Autowired
    private DocumentoService documentoService;

    @PostMapping
    public ResponseEntity<DocumentoDto> criar(@RequestBody DocumentoDto documentoDto) {
        DocumentoDto salva = documentoService.salvar(documentoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salva);
    }

    @GetMapping
    public List<DocumentoDto> listar() {
        return documentoService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentoDto> buscarPorId(@PathVariable Long id) {
        return documentoService.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        documentoService.excluir(id);
        return ResponseEntity.noContent().build();
    }

}