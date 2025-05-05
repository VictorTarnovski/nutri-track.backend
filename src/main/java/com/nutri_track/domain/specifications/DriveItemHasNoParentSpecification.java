package com.nutri_track.domain.specifications;

import com.nutri_track.domain.entities.DriveItem;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class DriveItemHasNoParentSpecification implements Specification<DriveItem> {
    public DriveItemHasNoParentSpecification() { }

    @Override
    public Predicate toPredicate(Root<DriveItem> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        return root.get("parent").isNull();
    }
}
