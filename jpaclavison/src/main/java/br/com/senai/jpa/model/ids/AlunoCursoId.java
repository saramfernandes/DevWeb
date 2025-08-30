package br.com.senai.jpa.model.ids;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode
public class AlunoCursoId {
    private Long alunoId;
    private Long cursoId;
}
