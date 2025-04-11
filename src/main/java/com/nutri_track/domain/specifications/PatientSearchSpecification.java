package com.nutri_track.domain.specifications;

import com.nutri_track.domain.entities.Patient;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class PatientSearchSpecification implements Specification<Patient> {
    private final String search;

    public PatientSearchSpecification(String search) {
        this.search = search;
    }

    @Override
    public Predicate toPredicate(Root<Patient> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        return builder.or(
                root.get("document").in(search),
                root.get("firstName").in(search),
                (root.get("lastName").in(search))
        );
    }
}
