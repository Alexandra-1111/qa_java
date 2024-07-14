package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LionParametrizedTest {
    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    void doesHaveManeWithParameters(String sex, boolean expectedHasMane) throws Exception {
        Lion lion = new Lion(sex, new Feline());

        assertEquals(lion.doesHaveMane(), expectedHasMane);
    }
    @Test
    void doesHaveManeWithException() {
        assertThrows(Exception.class,()-> new Lion("ДляОшибки", new Feline()));
    }
}
