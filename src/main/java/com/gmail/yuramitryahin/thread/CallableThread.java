package com.gmail.yuramitryahin.thread;

import java.util.List;
import java.util.concurrent.Callable;

public class CallableThread implements Callable<Integer> {
    private List<Integer> list;

    public CallableThread(List<Integer> list) {
        this.list = list;
    }

    @Override
    public Integer call() {
        return list
                .stream()
                .mapToInt(i -> i)
                .sum();
    }
}
