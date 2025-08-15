package br.com.senai.jpa.onetomany.dto;

import java.math.BigDecimal;

public class LivroDto {
    private Long id;
    private String titulo;
    private String isbn;
    private int paginas;
    private BigDecimal preco;
    private AutorDto autor;

    public LivroDto() {
    }

    public LivroDto(Long id, String titulo, String isbn, int paginas, BigDecimal preco, AutorDto autor) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.paginas = paginas;
        this.preco = preco;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public AutorDto getAutor() {
        return autor;
    }

    public void setAutor(AutorDto autor) {
        this.autor = autor;
    }
}
