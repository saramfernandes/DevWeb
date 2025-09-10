package br.com.senai.funcionario.service;

import br.com.senai.funcionario.dto.CargoDto;
import br.com.senai.funcionario.dto.mapper.CargoMapper;
import br.com.senai.funcionario.model.Cargo;
import br.com.senai.funcionario.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoService {

    @Autowired
    private CargoRepository repository;

    public CargoDto salvar(CargoDto dto) {
        Cargo cargo = CargoMapper.toEntity(dto);
        Cargo salvo = repository.save(cargo);
        return CargoMapper.toDto(salvo);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public CargoDto buscarPorId(Long id) {
        Cargo cargo = repository.findById(id).get();
        return CargoMapper.toDto(cargo);
    }

    public List<CargoDto> buscarTodos() {
        List<Cargo> cargos = repository.findAll();
        return cargos.stream().map(CargoMapper::toDto).toList();
    }

}
