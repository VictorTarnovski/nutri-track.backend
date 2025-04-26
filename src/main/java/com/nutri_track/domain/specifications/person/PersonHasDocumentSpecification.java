package com.nutri_track.domain.specifications.person;

import com.nutri_track.domain.entities.Person;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class PersonHasDocumentSpecification<TAggregate extends Person> implements Specification<TAggregate> {
    private final String document;

    public PersonHasDocumentSpecification(String document) {
        this.document = document;
    }

    @Override
    public Predicate toPredicate(Root<TAggregate> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        return builder.equal(root.get("document"), document);
    }
}
