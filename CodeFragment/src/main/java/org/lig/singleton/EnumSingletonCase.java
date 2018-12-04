package org.lig.singleton;

/**
 *
 *
 */
public enum EnumSingletonCase {
    INSTANCE;

    public void sayHello() {
        System.out.println("-----------------");
    }

    public static void main(String[] args) {
        EnumSingletonCase.INSTANCE.sayHello();


    }
}

