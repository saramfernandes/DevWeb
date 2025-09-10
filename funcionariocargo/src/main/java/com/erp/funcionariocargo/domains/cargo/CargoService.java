package com.erp.funcionariocargo.domains.cargo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoService {

    @Autowired
    private CargoRepository repository;

    public CargoDTO salvar(CargoDTO dto) {
        Cargo cargo = CargoMapper.toEntity(dto);
        Cargo salvo = repository.save(cargo);
        return CargoMapper.toDto(salvo);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public CargoDTO buscarPorId(Long id) {
        Cargo cargo = repository.findById(id).orElse(null);
        return CargoMapper.toDto(cargo);
    }

    public List<CargoDTO> buscarTodos() {
        List<Cargo> cargos = repository.findAll();
        return cargos.stream().map(CargoMapper::toDto).toList();
    }

    public Page<Cargo> getCargosPaginados(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable);
    }

}
