package com.nutri_track.domain.specifications;

import com.nutri_track.domain.entities.Appointment;
import com.nutri_track.domain.entities.Professional;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class AppointmentHasProfessionalSpecification implements Specification<Appointment> {
    private final Professional professional;

    public AppointmentHasProfessionalSpecification(Professional professional) {
        this.professional = professional;
    }

    @Override
    public Predicate toPredicate(Root<Appointment> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
      return builder.equal(root.get("professional").get("id"), professional.id());
    }
}
