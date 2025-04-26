package com.nutri_track.domain.specifications.professionals;

import com.nutri_track.domain.entities.Professional;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.Arrays;


public class ProfessionalSearchSpecification implements Specification<Professional> {
    private final String search;

    public ProfessionalSearchSpecification(String search) {
        this.search = search;
    }

    @Override
    public Predicate toPredicate(Root<Professional> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
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
