//package com.example.demo.retry;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.retry.interceptor.RetryInterceptorBuilder;
//import org.springframework.retry.interceptor.RetryOperationsInterceptor;
//
//@Configuration
//public class RetryOperationsInterceptorConfig {
//
//    @Bean
//    public RetryOperationsInterceptor retryInterceptor() {
//        System.out.println("Retry interceptor is called");
//        return RetryInterceptorBuilder
//                .stateless()
////                .retryPolicy()
//                .maxAttempts(5).build();
//    }
//}
