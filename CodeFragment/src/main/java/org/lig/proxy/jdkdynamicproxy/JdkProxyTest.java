package org.lig.proxy.jdkdynamicproxy;

import java.lang.reflect.Proxy;

public class JdkProxyTest {
    public static void main(String[] args) {
        HelloService helloService = (HelloService)Proxy.newProxyInstance(JdkProxyTest.class.getClassLoader(),new Class<?>[]{HelloService.class},new MyInvocationHandler(new HelloServiceImpl()));
        helloService.sayHello();
    }
}
