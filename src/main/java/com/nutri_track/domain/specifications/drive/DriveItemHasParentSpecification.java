package com.nutri_track.domain.specifications.drive;

import com.nutri_track.domain.entities.DriveItem;
import com.nutri_track.domain.entities.Folder;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class DriveItemHasParentSpecification<TAggregate extends DriveItem> implements Specification<TAggregate> {
    private final Folder parent;

    public DriveItemHasParentSpecification(Folder parent) {
        this.parent = parent;
    }

    @Override
    public Predicate toPredicate(Root<TAggregate> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        if (parent == null) {
            return root.get("parent").isNull();
        } else {
            return builder.equal(root.get("parent"), parent);
        }
    }
}
