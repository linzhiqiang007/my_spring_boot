package com.community.services.runnable;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Worker implements Runnable {

    private CountDownLatch countDownLatch = new CountDownLatch(1000);

    private ExecutorService executor = Executors.newCachedThreadPool();

    @Override
    public void run() {
    }
}
