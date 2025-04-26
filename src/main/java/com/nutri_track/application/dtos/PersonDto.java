package com.nutri_track.application.dtos;

import com.nutri_track.application.dtos.builders.AddressDtoBuilder;
import com.nutri_track.domain.entities.Person;

public class PersonDto extends EntityDto {
    public String document;
    public String firstName;
    public String lastName;
    public AddressDto address;

    public PersonDto(Person person) {
        super(person.id());
        document = person.document();
        firstName = person.firstName();
        lastName = person.lastName();
        address = new AddressDtoBuilder()
                .withLine1(person.addressLine1())
                .withLine2(person.addressLine2())
                .withCity(person.city())
                .withRegion(person.region())
                .withPostalCode(person.postalCode())
                .withCountryCode(person.countryCode())
                .build();
    }
}
