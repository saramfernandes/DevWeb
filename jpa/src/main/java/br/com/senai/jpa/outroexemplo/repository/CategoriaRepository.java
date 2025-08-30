package br.com.senai.jpa.outroexemplo.repository;


import br.com.senai.jpa.outroexemplo.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
