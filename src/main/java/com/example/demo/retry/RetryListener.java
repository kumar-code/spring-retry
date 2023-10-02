package com.example.demo.retry;

import org.apache.tomcat.util.ExceptionUtils;
import org.springframework.retry.RetryContext;
import org.springframework.retry.interceptor.MethodInvocationRetryCallback;
import org.springframework.retry.listener.MethodInvocationRetryListenerSupport;
import org.springframework.stereotype.Component;

@Component
public class RetryListener extends MethodInvocationRetryListenerSupport {

    private boolean isAxonEnabled = true;


    @Override
    protected <T, E extends Throwable> boolean doOpen(RetryContext context,
                                                      MethodInvocationRetryCallback<T, E> callback) {
        System.out.println("Exception Occurred, Retry Session Started...");
        return true;
    }

    @Override
    protected <T, E extends Throwable> void doOnSuccess(RetryContext context,
                                                        MethodInvocationRetryCallback<T, E> callback, T result) {
        System.out.println("Retries got success...");
        if (!isAxonEnabled) {
            isAxonEnabled = true;
            System.out.println("Restarting axon consumer.. ");
            System.out.println("Axon consumer status : " + isAxonEnabled);
        }
    }

    @Override
    protected <T, E extends Throwable> void doOnError(RetryContext context,
                                                      MethodInvocationRetryCallback<T, E> callback, Throwable throwable) {
        if (isAxonEnabled) {
            isAxonEnabled = false;
            System.out.println("Closing the axon consumer...");
            System.out.println("Axon consumer status : " + isAxonEnabled);
        }

        System.out.println("Exception Occurred, Retry Count : " + context.getRetryCount());
        System.out.println("Retry attempt " + context.getRetryCount() + ", for retractable method : " + context.getAttribute("context.name")
                        + ", threw exception : " +  ExceptionUtils.unwrapInvocationTargetException(throwable));
    }
}


