package org.lig.jdkthreadlock;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalTester {

    public static ThreadLocal local = new ThreadLocal();
    final int threadLocalHashCode = nextHashCode();
    public static void main(String[] args) {

        System.out.println(local.get());

        local.set("abcd");

        System.out.println(local.get());

        local.set("efgh");

        System.out.println(local.get());
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

    }

    private static AtomicInteger nextHashCode =
            new AtomicInteger();

    private static final int HASH_INCREMENT = 0x61c88647;

    private static int nextHashCode() {
        System.out.println("get");
        return nextHashCode.getAndAdd(HASH_INCREMENT);
    }
}
