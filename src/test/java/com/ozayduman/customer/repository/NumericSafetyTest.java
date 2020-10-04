package com.ozayduman.customer.repository;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumericSafetyTest {

    @Test
    void numericSafety() {
        double result = 1.04 - 0.43;
        double expected = 0.61;
        assertEquals(expected, result);
    }
}
