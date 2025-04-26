package com.nutri_track.domain.specifications.appointments;

import com.nutri_track.domain.entities.Appointment;
import com.nutri_track.domain.value_objects.OffsetDateTimeRange;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.time.OffsetDateTime;

public class AppointmentIsScheduledBetweenSpecification implements Specification<Appointment> {
    private final OffsetDateTimeRange schedule;

    public AppointmentIsScheduledBetweenSpecification(OffsetDateTimeRange schedule) {
        this.schedule = schedule;
    }

    @Override
    public Predicate toPredicate(Root<Appointment> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
       var start = root.get("scheduledTo").get("start").as(OffsetDateTime.class);
       var end = root.get("scheduledTo").get("end").as(OffsetDateTime.class);

       return builder.and(
               builder.greaterThanOrEqualTo(
                       start,
                       schedule.start()
               ),
               builder.lessThanOrEqualTo(
                       end,
                       schedule.end()
               )
       );
    }
}
