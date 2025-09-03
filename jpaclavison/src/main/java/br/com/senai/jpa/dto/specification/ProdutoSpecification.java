package br.com.senai.jpa.dto.specification;

import br.com.senai.jpa.dto.ProdutoFiltroDto;
import br.com.senai.jpa.model.Produto;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class ProdutoSpecification {

    public static Specification<Produto> comFiltros(ProdutoFiltroDto filtro) {
        return (root, query, cb) -> {
                Predicate predicate = cb.conjunction();
        if (filtro.getNome() != null  && !filtro.getNome().isEmpty()){
            predicate = cb.and(predicate, cb.like(cb.lower(root.get("nome")), "%" +
                    filtro.getNome().toLowerCase() + "%"));
        }
        if (filtro.getDescricao() != null && !filtro.getDescricao().isEmpty()){
            predicate = cb.and(predicate, cb.like(cb.lower(root.get("descricao")), "%" +
                    filtro.getDescricao().toLowerCase() + "%"));
        }
        if (filtro.getCategoria() != null && !filtro.getCategoria().isEmpty()) {
            predicate = cb.and(predicate, cb.equal(root.get("categoria"), filtro.getCategoria()));
        }
        if (filtro.getPrecoMin() != null) {
            predicate = cb.and(predicate, cb.greaterThanOrEqualTo(root.get("preco"), filtro.getPrecoMin()));
        }
        if (filtro.getPrecoMax() != null) {
            predicate = cb.and(predicate, cb.lessThanOrEqualTo(root.get("preco"), filtro.getPrecoMax()));
        }
        return predicate;

        };
    }
}

