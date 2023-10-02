package com.example.demo.service;


import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
@EnableRetry
public class NetworkService {
    @Retryable(value = RuntimeException.class, maxAttempts = 5
            ,listeners = {"retryListener"}
    )
    public void configureNetworkSystem(){
        verifyNwConfiguration();
    }

    int counter = 0;

    @Recover
    public void recover(RuntimeException ex) {
        System.out.println("Recovery methods -- ending execution");
    }

    private void verifyNwConfiguration(){
        counter++;

        if(counter < 4) {
            System.out.println("N/W configuration Service Failed ");
            throw new RuntimeException();
        }
        System.out.println("N/W configuration Service got success ");
    }
}