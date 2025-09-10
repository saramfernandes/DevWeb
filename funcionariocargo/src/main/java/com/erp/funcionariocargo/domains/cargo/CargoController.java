package com.erp.funcionariocargo.domains.cargo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cargos")
public class CargoController {

    @Autowired
    private CargoService service;

    @PostMapping
    public ResponseEntity<CargoDTO> criar(@RequestBody CargoDTO cargo) {
        CargoDTO salvo = service.salvar(cargo);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CargoDTO> buscarPorId(@PathVariable Long id) {
        CargoDTO cargo = service.buscarPorId(id);
        if (cargo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cargo);
    }

    @GetMapping
    public Page<Cargo> getCargos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size) {
        return service.getCargosPaginados(page, size);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CargoDTO> atualizar(@PathVariable Long id, @RequestBody CargoDTO cargo) {
        CargoDTO cargoBusca = service.buscarPorId(id);
        if (cargoBusca == null) {
            return ResponseEntity.notFound().build();
        } else {
            cargo.setId(id);
            return ResponseEntity.ok(service.salvar(cargo));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
