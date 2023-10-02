//package com.example.demo.retry;
//
//import org.aopalliance.intercept.MethodInterceptor;
//import org.aopalliance.intercept.MethodInvocation;
//import org.springframework.stereotype.Component;
//
//@Component
//public class RetryMethodInterceptor implements MethodInterceptor {
//    @Override
//    public Object invoke(MethodInvocation invocation) throws Throwable {
//        System.out.println("Inside retry interceptor");
//        return invocation.proceed();
//    }
//}
