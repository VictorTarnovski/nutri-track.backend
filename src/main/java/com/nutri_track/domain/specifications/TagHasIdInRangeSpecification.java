package com.nutri_track.domain.specifications;

import com.nutri_track.domain.entities.Tag;

import java.util.List;

public class TagHasIdInRangeSpecification extends HasIdInRangeSpecification<Tag> {
    public TagHasIdInRangeSpecification(List<Long> tagIds) {
        super(tagIds);
    }
}
