package com.aor.numbers;

import java.util.ArrayList;
import java.util.List;

public class ListFilterer {
    private final GenericListFilter filter;

    public ListFilterer(GenericListFilter filter) {
        this.filter = filter;
    }

    public List<Integer> filter(List<Integer> list) {
        List<Integer> aList= new ArrayList<>();
        for (Integer a: list) {
            if (filter.accept(a))
                aList.add(a);
        }
        return aList;
    }

}
