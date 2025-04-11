package com.nutri_track.domain.dtos;

import com.nutri_track.domain.entities.Person;

public class PersonDto extends EntityDto {
    public String document;
    public String firstName;
    public String lastName;

    public PersonDto(Person person) {
        super(person.id());
        document = person.document();
        firstName = person.firstName();
        lastName = person.lastName();
    }
}
