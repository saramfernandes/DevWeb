package br.com.senai.jpa.onetomanyemanytomany.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LivroDto {
    private Long id;
    private String titulo;
    private String isbn;
    private int paginas;
    private BigDecimal preco;
    private AutorDto autor;
    private List<CategoriaDto> categorias;

}
