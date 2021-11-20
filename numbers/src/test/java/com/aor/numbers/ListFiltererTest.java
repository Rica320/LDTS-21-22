package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListFiltererTest {
    List<Integer> list;
    List<Integer> expected;

    @BeforeEach
    void setUp() {
        list = Arrays.asList(-3,2,0,3);
        expected = Arrays.asList(-3,2,0,3);
    }

    @Test
    void filter(){

        GenericListFilter filter = Mockito.mock(GenericListFilter.class);
        Mockito.when(filter.accept(Mockito.anyInt())).thenReturn(true); // true for every integer

        ListFilterer filterer = new ListFilterer(filter);
        List<Integer> result = filterer.filter(list);

        Assertions.assertEquals(expected, result);
    }
}
