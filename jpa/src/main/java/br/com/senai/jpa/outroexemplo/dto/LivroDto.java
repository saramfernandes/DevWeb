package br.com.senai.jpa.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class LivroDto {

    private Long id;
    private String titulo;
    private String isbn;
    private int paginas;
    private BigDecimal preco;
    private AutorDto autor;
    private List<CategoriaDto> categoriasDto = new ArrayList<>();

}
