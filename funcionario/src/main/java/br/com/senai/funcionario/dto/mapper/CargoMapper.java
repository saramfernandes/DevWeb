package br.com.senai.funcionario.dto.mapper;

import br.com.senai.funcionario.dto.CargoDto;
import br.com.senai.funcionario.model.Cargo;

public class CargoMapper {
    public static CargoDto toDto(Cargo cargo) {
        if(cargo == null) return null;
        return new CargoDto(
                cargo.getNome(),
                cargo.getSalario()
        );
    }

    public static Cargo toEntity(CargoDto dto) {
        if(dto == null) return null;
        Cargo cargo = new Cargo();
        cargo.setNome(dto.getNome());
        cargo.setSalario(dto.getSalario());
        return cargo;
    }
}
