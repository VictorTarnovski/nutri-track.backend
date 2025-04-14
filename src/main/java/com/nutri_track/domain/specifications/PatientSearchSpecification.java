package com.nutri_track.domain.specifications;

import com.nutri_track.domain.entities.Patient;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.Arrays;


public class PatientSearchSpecification implements Specification<Patient> {
    private final String search;

    public PatientSearchSpecification(String search) {
        this.search = search;
    }

    @Override
    public Predicate toPredicate(Root<Patient> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        var paths = Arrays.asList("document", "firstName", "lastName");
        var predicates = new ArrayList<Predicate>();

        for (String path: paths) {
            var predicate = builder.like(
                    builder.lower(root.get(path)),
                    "%" + search.toLowerCase() + "%"
            );

            predicates.add(predicate);
        }

        return builder.or(predicates.toArray(Predicate[]::new));
    }
}
