package org.lig.interview;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreeThreadOutput100 {
    static Lock lock = new ReentrantLock();
    static Condition con1 = lock.newCondition();
    static Condition con2 = lock.newCondition();
    static Integer num = 1;
    public void test(){
        new Thread(new Print1()).start();
        new Thread(new Print2()).start();
    }
    public static void main(String[] args) {
        ThreeThreadOutput100 tester = new ThreeThreadOutput100();
        tester.test();

    }
    static class Print1 implements Runnable {

        @Override
        public void run() {
            lock.lock();
            while(num<=100){
                if (num % 2 != 1) {
                    try {
                        con1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Print1:"+(num++));
                con2.signal();
            }
            lock.unlock();
        }
    }


    class Print2 implements Runnable {

        @Override
        public void run() {
            lock.lock();

            while(num<=100){
                if (num % 2 !=0) {
                    try {
                        con2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Print2:"+(num++));
                con1.signal();
            }
            lock.unlock();

        }
    }
}

