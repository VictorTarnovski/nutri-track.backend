package com.nutri_track.domain.specifications.drive;

import com.nutri_track.domain.entities.DriveItem;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class DriveItemHasProfessionalIdSpecification<TAggregate extends DriveItem> implements Specification<TAggregate> {
    private final long professionalId;

    public DriveItemHasProfessionalIdSpecification(long professionalId) {
        this.professionalId = professionalId;
    }

    @Override
    public Predicate toPredicate(Root<TAggregate> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        return builder.equal(root.get("professional").get("id"), professionalId);
    }
}
