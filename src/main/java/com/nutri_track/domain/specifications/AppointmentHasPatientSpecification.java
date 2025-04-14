package com.nutri_track.domain.specifications;

import com.nutri_track.domain.entities.Appointment;
import com.nutri_track.domain.entities.Patient;
import com.nutri_track.domain.value_objects.OffsetDateTimeRange;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.time.OffsetDateTime;

public class AppointmentHasPatientSpecification implements Specification<Appointment> {
    private final Patient patient;

    public AppointmentHasPatientSpecification(Patient patient) {
        this.patient = patient;
    }

    @Override
    public Predicate toPredicate(Root<Appointment> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
      return builder.equal(root.get("patient").get("id"), patient.id());
    }
}
