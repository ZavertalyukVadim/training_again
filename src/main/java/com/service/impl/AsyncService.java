package com.service.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    @Async
    public void printInConsole() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            System.out.println("Async hello");
            Thread.sleep(1000);
        }
    }
}
