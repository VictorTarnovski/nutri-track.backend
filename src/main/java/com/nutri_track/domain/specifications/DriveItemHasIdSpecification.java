package com.nutri_track.domain.specifications;

import com.nutri_track.domain.entities.DriveItem;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;

public abstract class DriveItemHasIdSpecification<TAggregate extends DriveItem> implements Specification<TAggregate> {
    private final UUID id;

    public DriveItemHasIdSpecification(UUID id) {
        this.id = id;
    }

    @Override
    public Predicate toPredicate(Root<TAggregate> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        return builder.equal(root.get("id"), id);
    }
}
