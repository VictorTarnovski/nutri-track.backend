package com.nutri_track.domain.value_objects;

import com.nutri_track.domain.value_objects.builders.AddressBuilder;
import org.junit.jupiter.api.Nested;
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

    @Test
    void should_create_an_address() {
        // Arrange
        var builder = new AddressBuilder()
                .withLine1("")
                .withLine2("")
                .withCity("")
                .withRegion("")
                .withPostalCode("")
                .withCountryCode("");

        // Assert
        assertDoesNotThrow(builder::build);
    }

    @Nested
    class US {
        @Test
        void should_create_a_US_address() {
            // Arrange
            var builder = new AddressBuilder()
                    .withLine1("John Doe")
                    .withLine2("1234 Elm St, Apt 56B")
                    .withCity("Chicago")
                    .withRegion("IL")
                    .withPostalCode("60601")
                    .withCountryCode("US");

            // Assert
            assertDoesNotThrow(builder::build);
        }
    }

    @Nested
    class ENG {
        @Test
        void should_create_a_ENG_address() {
            // Arrange
            var builder = new AddressBuilder()
                    .withLine1("John Doe")
                    .withLine2("2045 Royal Road")
                    .withCity("Chelsea")
                    .withRegion("London")
                    .withPostalCode("SW1W 8EG")
                    .withCountryCode("GB-ENG");

            // Assert
            assertDoesNotThrow(builder::build);
        }
    }

    @Nested
    class BR {
        @Test
        void should_create_a_BR_address() {
            // Arrange
            var builder = new AddressBuilder()
                    .withLine1("John Doe")
                    .withLine2("Rua Álvaro Correa Alves, 596 - Santa Terezinha")
                    .withCity("Piracicaba")
                    .withRegion("SP")
                    .withPostalCode("13411-025")
                    .withCountryCode("BR");

            // Assert
            assertDoesNotThrow(builder::build);
        }
    }
}
