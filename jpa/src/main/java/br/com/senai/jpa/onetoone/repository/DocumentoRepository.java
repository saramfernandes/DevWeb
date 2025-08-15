package br.com.senai.jpa.onetoone.repository;

import br.com.senai.jpa.onetoone.model.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {
    Documento findByCpf(String cpf);

    @Query("SELECT d FROM Documento d WHERE d.rg = :rg")
    Documento findByRg(@Param("rg") String rg);

    @Query("SELECT d FROM Documento d WHERE d.pessoa.nome LIKE %:nome%")
    List<Documento> findByNomeDaPessoa(@Param("nome") String nome);
}
