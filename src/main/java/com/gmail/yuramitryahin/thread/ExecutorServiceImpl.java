package com.gmail.yuramitryahin.thread;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.commons.collections4.ListUtils;

public class ExecutorServiceImpl {
    private static final int NUMBER_OF_THREADS = Runtime.getRuntime().availableProcessors();
    private final List<Integer> numbers;

    public ExecutorServiceImpl(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public BigInteger findSum() {
        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        List<Callable<Integer>> callableTasks = new ArrayList<>();

        int numberOfPartition = numbers.size() / NUMBER_OF_THREADS;
        List<List<Integer>> partition = ListUtils.partition(numbers,
                numberOfPartition == 0 ? 1 : numberOfPartition);
        for (List<Integer> list : partition) {
            callableTasks.add(new CallableThread(list));
        }
        BigInteger sum = BigInteger.valueOf(0);
        try {
            List<Future<Integer>> futures = executor.invokeAll(callableTasks);
            executor.shutdown();
            for (int i = 0; i < futures.size(); i++) {
                if (futures.get(i).isDone()) {
                    sum = sum.add(BigInteger.valueOf(futures.get(i).get()));
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            new RuntimeException("Can't calculate sum at ExecutorService!", e);
        }
        return sum;
    }
}
