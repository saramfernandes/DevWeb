package br.com.senai.jpa.repository;

import br.com.senai.jpa.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Pessoa findByEmail(String email);
    List<Pessoa> findByNomeLike(String nome);

    @Query("SELECT p FROM Pessoa p WHERE p.dataNascimento < :data")
    List<Pessoa>
    findPessoasNascidasAntesDe(@Param("data") LocalDate data);

    @Query("SELECT p FROM Pessoa p WHERE p.documento.cpf = :cpf")
    Pessoa findByCpfDoDocumento(@Param("cpf") String cpf);
}
