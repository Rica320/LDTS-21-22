package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DivisibleByFilterTest {

    DivisibleByFilter filter;

    @BeforeEach
    void setUp() {
        this.filter = new DivisibleByFilter(5);
    }

    @Test
    void accept_not_divisible(){
        Assertions.assertEquals(false, filter.accept(3));
    }

    @Test
    void accept_divisible(){
        Assertions.assertEquals(true, filter.accept(25));
    }

    @Test
    void accept_neutral(){
        Assertions.assertEquals(true, filter.accept(0));
    }
}
