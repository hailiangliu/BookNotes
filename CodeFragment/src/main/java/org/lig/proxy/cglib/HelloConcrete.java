package org.lig.proxy.cglib;

public class HelloConcrete {

    public String sayHello(String name){
        System.out.println("hello : " + name);
        return "response: " + name;
    }

    public static void main(String[] args) {
    }
}
