package com.nutri_track.domain.specifications;

import com.nutri_track.domain.entities.AbstractAggregateRoot;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public abstract class HasIdInRangeSpecification<TAggregate extends AbstractAggregateRoot> implements Specification<TAggregate> {
    private final List<Long> ids;

    public HasIdInRangeSpecification(List<Long> ids) {
        this.ids = ids;
    }

    @Override
    public Predicate toPredicate(Root<TAggregate> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        return root.get("id").in(ids);
    }
}
