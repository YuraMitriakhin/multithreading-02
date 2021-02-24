package com.gmail.yuramitryahin.thread;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinImpl extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 10000;
    private static final int SUB_SIZE = 1000;
    private List<Integer> numbers;

    public ForkJoinImpl(List<Integer> arr) {
        this.numbers = arr;
    }

    @Override
    public Integer compute() {
        if (numbers.size() > THRESHOLD) {
            return ForkJoinTask.invokeAll(createSubtasks(numbers)).stream()
                    .mapToInt(ForkJoinTask::join)
                    .sum();
        }
        return processing();
    }

    private Collection<ForkJoinImpl> createSubtasks(List<Integer> list) {
        List<ForkJoinImpl> dividedTasks = new ArrayList<>();
        for (int i = 0; i < list.size(); i += SUB_SIZE) {
            dividedTasks.add(new ForkJoinImpl(new ArrayList<>(list.subList(i,
                    Math.min(list.size(), i + SUB_SIZE)))));
        }
        return dividedTasks;
    }

    private Integer processing() {
        return numbers
                .stream()
                .mapToInt(a -> a)
                .sum();
    }
}
