package org.lig.proxy.jdkdynamicproxy;

public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello() {
        System.out.println("HelloServiceImpl.sayHello");
    }
}
