package com.erp.funcionariocargo.domains.funcionario;

import com.erp.funcionariocargo.domains.cargo.Cargo;
import com.erp.funcionariocargo.domains.cargo.CargoService;
import com.erp.funcionariocargo.domains.cargo.CargoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    @Autowired
    private CargoService cargoService;

    public FuncionarioDTO salvar(FuncionarioDTO dto) {
        Funcionario funcionario = FuncionarioMapper.toEntity(dto);
        
        // Buscar o cargo pelo ID se fornecido
        if (dto.getCargo() != null && dto.getCargo().getId() != null) {
            Cargo cargo = cargoService.buscarPorId(dto.getCargo().getId()) != null ? 
                CargoMapper.toEntity(cargoService.buscarPorId(dto.getCargo().getId())) : null;
            funcionario.setCargo(cargo);
        }
        
        Funcionario salvo = repository.save(funcionario);
        return FuncionarioMapper.toDto(salvo);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public FuncionarioDTO buscarPorId(Long id) {
        Funcionario funcionario = repository.findById(id).orElse(null);
        return FuncionarioMapper.toDto(funcionario);
    }

    public List<FuncionarioDTO> buscarTodos() {
        List<Funcionario> funcionarios = repository.findAll();
        return funcionarios.stream().map(FuncionarioMapper::toDto).toList();
    }

    public List<FuncionarioDTO> buscarPorSalarioBetween(Double salarioMin, Double salarioMax) {
        List<Funcionario> funcionarios = repository.findByCargoSalarioBetween(salarioMin, salarioMax);
        return funcionarios.stream().map(FuncionarioMapper::toDto).toList();
    }

    public Page<Funcionario> getFuncionariosPaginados(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable);
    }
}
