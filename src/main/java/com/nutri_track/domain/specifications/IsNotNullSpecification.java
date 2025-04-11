package com.nutri_track.domain.specifications;

import com.nutri_track.domain.entities.AbstractAggregateRoot;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public abstract class IsNotNullSpecification<TAggregate extends AbstractAggregateRoot> implements Specification<TAggregate> {
    @Override
    public Predicate toPredicate(Root<TAggregate> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        return root.isNotNull();
    }
}
