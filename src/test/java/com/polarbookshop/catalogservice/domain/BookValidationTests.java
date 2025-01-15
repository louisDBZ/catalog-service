package com.polarbookshop.catalogservice.domain;

import java.util.Set;
import jakarta.validation.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

//on a enlevé le coté public
class BookValidationTests {
    private static Validator validator;

    @BeforeAll
    static void setup(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void whenAllFieldsCorrectThenValidationSucceeds(){
        var book = new Book("1234567891","Title","Author",9.90);
        Set <ConstraintViolation<Book>> violations = validator.validate(book);
        assertThat(violations).isEmpty();
    }

    @Test
    void whenIsbnDefinedButIncorrectThenValidationFails(){
        var book = new Book("a234567891","Title","Author",9.90);
        Set <ConstraintViolation<Book>> violations = validator.validate(book);
        assertThat(violations).hasSize(1);
        assertThat(violations.iterator().next().getMessage()).isEqualTo("The ISBN format must be valid");
    }


}
