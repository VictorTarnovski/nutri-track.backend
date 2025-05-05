package com.nutri_track.domain.specifications;

import com.nutri_track.domain.entities.DriveItem;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class DriveItemHasProfessionalIdSpecification implements Specification<DriveItem> {
    private final long professionalId;

    public DriveItemHasProfessionalIdSpecification(long professionalId) {
        this.professionalId = professionalId;
    }

    @Override
    public Predicate toPredicate(Root<DriveItem> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        return builder.equal(root.get("professional").get("id"), professionalId);
    }
}
