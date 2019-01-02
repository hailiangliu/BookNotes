package org.lig.jdklock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试 juc 中 lock 的newCondition的使用
 *
 * 实现lock上的wait和notify
 *
 */
public class LockConditionTester {

    public static void main(String[] args) {
        final Lock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();

        new Thread( new Runnable(){
            @Override
            public void run() {
                lock.tryLock();
                try {
                    System.out.println(Thread.currentThread().getName()+" run and await ..");
                    condition.await();
                    System.out.println(Thread.currentThread().getName()+" notify ...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        } ).start();
        new Thread( new Runnable(){
            @Override
            public void run() {
                lock.tryLock();
                try {
                    System.out.println(Thread.currentThread().getName()+" 咔咔咔");
                    condition.await();
                    System.out.println(Thread.currentThread().getName()+" notify ...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        } ).start();;


    }

}


