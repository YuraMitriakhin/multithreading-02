package com.gmail.yuramitryahin;

import com.gmail.yuramitryahin.thread.ExecutorServiceImpl;
import com.gmail.yuramitryahin.thread.ForkJoinImpl;
import com.gmail.yuramitryahin.util.Util;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorServiceImpl executorService = new ExecutorServiceImpl(Util.generateRandomList());
        System.out.println(executorService.findSum());
        ForkJoinImpl customRecursiveTask = new ForkJoinImpl(Util.generateRandomList());
        System.out.println(customRecursiveTask.compute());
    }
}
