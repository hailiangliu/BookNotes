package org.lig.interview;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 面试题：
 *  3个线程，a线程输出a，b线程输出b，c线程输出c
 *  控制abc顺序，输出10ci
 */
public class SerialOutputABC {

    static Lock lock = new ReentrantLock();
    static Condition a=lock.newCondition();
    static Condition b=lock.newCondition();
    static Condition c=lock.newCondition();

    static int state = 0;

    static class A implements Runnable {
        @Override
        public void run() {
            lock.lock();
            for (int i = 0; i <10 ; i++) {
                while(state%3!=0){
                    try {
                        a.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("A");
                state++;
                b.signal();
            }
            lock.unlock();
        }
    };

    static class B implements Runnable {
        @Override
        public void run() {
            lock.lock();
            for (int i = 0; i <10 ; i++) {
                while(state%3!=1){
                    try {
                        b.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("B");
                state++;
                c.signal();
            }
            lock.unlock();
        }
    };
    static class C implements Runnable {
        @Override
        public void run() {
            lock.lock();
            for (int i = 0; i <10 ; i++) {
                while(state%3!=2){
                    try {
                        c.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("C");
                state++;
                a.signal();
            }
            lock.unlock();
        }
    };

    public static void main(String[] args) {
        new Thread(new SerialOutputABC.A()).start();
        new Thread(new SerialOutputABC.B()).start();
        new Thread(new SerialOutputABC.C()).start();
    }
}
