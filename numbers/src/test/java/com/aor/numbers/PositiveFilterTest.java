package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PositiveFilterTest {

    PositiveFilter filter;

    @BeforeEach
    void setUp() {
        this.filter = new PositiveFilter();
    }

    @Test
    void accept_positive(){
        Assertions.assertEquals(true, filter.accept(Integer.MAX_VALUE));
    }

    @Test
    void accept_negative(){
        Assertions.assertEquals(false, filter.accept(Integer.MIN_VALUE));
    }

    @Test
    void accept_neutral(){
        Assertions.assertEquals(false, filter.accept(0));
    }
}
