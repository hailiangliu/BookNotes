package org.lig.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

public class TestMain {
    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloConcrete.class);
        enhancer.setCallback(new MyMethodInterceptor());

        HelloConcrete helloConcrete = (HelloConcrete)enhancer.create();
        String resp = helloConcrete.sayHello("SB");
        System.out.println("Result:"+resp);


    }
}
