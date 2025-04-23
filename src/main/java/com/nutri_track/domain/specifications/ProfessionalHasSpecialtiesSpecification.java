package com.nutri_track.domain.specifications;

import com.nutri_track.domain.entities.Professional;
import com.nutri_track.domain.value_objects.Specialty;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.Set;

public class ProfessionalHasSpecialtiesSpecification implements Specification<Professional> {

    private final Set<Long> specialtyIds;

    public ProfessionalHasSpecialtiesSpecification(Set<Long> specialtyIds) {
        this.specialtyIds = specialtyIds;
    }

    @Override
    public Predicate toPredicate(Root<Professional> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        Join<Professional, Specialty> specialtiesJoin = root.join("specialties", JoinType.INNER);
        query.distinct(true);

        return specialtiesJoin.get("id").in(specialtyIds);
    }
}


