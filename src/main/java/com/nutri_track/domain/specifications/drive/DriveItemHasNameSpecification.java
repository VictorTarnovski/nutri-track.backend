package com.nutri_track.domain.specifications.drive;

import com.nutri_track.domain.entities.DriveItem;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public abstract class DriveItemHasNameSpecification<TAggregate extends DriveItem> implements Specification<TAggregate> {
    private final String name;

    public DriveItemHasNameSpecification(String name) {
        this.name = name;
    }

    @Override
    public Predicate toPredicate(Root<TAggregate> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        return  builder.equal(root.get("name"), this.name);
    }
}
