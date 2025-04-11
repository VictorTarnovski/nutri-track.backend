package com.nutri_track.domain.specifications;

import com.nutri_track.domain.entities.AbstractAggregateRoot;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public abstract class HasIdSpecification<TAggregate extends AbstractAggregateRoot> implements Specification<TAggregate> {
    private final Long id;

    public HasIdSpecification(Long id) {
        this.id = id;
    }

    @Override
    public Predicate toPredicate(Root<TAggregate> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        return builder.equal(root.get("id"), id);
    }
}
