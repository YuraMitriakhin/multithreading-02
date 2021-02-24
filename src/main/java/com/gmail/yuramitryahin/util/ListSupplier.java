package com.gmail.yuramitryahin.util;

import java.util.ArrayList;
import java.util.List;

public class ListSupplier {
    private static final int LENGTH = 1000000;

    public static List<Integer> generateRandomList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < LENGTH; i++) {
            list.add((int) (Math.random() * 100));
        }
        return list;
    }
}
