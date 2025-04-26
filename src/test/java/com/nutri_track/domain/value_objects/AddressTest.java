package com.nutri_track.domain.value_objects;

import com.nutri_track.domain.value_objects.builders.AddressBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddressTest {
    @Test
    void should_throw_when_line1_is_null() {
        var builder = new AddressBuilder()
                .withLine1(null)
                .withLine2("")
                .withCity("")
                .withRegion("")
                .withPostalCode("")
                .withCountryCode("");

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            //Act
            builder.build();
        });
    }

    @Test
    void should_throw_when_line2_is_null() {
        // Arrange
        var builder = new AddressBuilder()
                .withLine1("")
                .withLine2(null)
                .withCity("")
                .withRegion("")
                .withPostalCode("")
                .withCountryCode("");

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            //Act
            builder.build();
        });
    }

    @Test
    void should_throw_when_city_is_null() {
        // Arrange
        var builder = new AddressBuilder()
                .withLine1("")
                .withLine2("")
                .withCity(null)
                .withRegion("")
                .withPostalCode("")
                .withCountryCode("");

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            //Act
            builder.build();
        });
    }

    @Test
    void should_throw_when_region_is_null() {
        // Arrange
        var builder = new AddressBuilder()
                .withLine1("")
                .withLine2("")
                .withCity("")
                .withRegion(null)
                .withPostalCode("")
                .withCountryCode("");

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            //Act
            builder.build();
        });
    }

    @Test
    void should_throw_when_postalCode_is_null() {
        // Arrange
        var builder = new AddressBuilder()
                .withLine1("")
                .withLine2("")
                .withCity("")
                .withRegion("")
                .withPostalCode("")
                .withCountryCode(null);

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            //Act
            builder.build();
        });
    }

    @Test
    void should_throw_when_countryCode_is_null() {
        // Arrange
        var builder = new AddressBuilder()
                .withLine1("")
                .withLine2("")
                .withCity("")
                .withRegion("")
                .withPostalCode("")
                .withCountryCode(null);

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            //Act
            builder.build();
        });
    }

}
