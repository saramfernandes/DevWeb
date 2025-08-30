package br.com.senai.jpa.outroexemplo.repository;


import br.com.senai.jpa.outroexemplo.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
