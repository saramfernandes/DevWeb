package br.com.senai.jpa.outroexemplo.model.ids;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter @Setter
public class AlunoCursoId {

    private Long alunoId;
    private Long cursoId;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AlunoCursoId that = (AlunoCursoId) o;
        return Objects.equals(alunoId, that.alunoId) && Objects.equals(cursoId, that.cursoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alunoId, cursoId);
    }

}
