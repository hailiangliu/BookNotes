package org.lig.jdkthreadpool;

import java.sql.SQLOutput;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 *
 */
public class ThreadPoolTester {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool( 1 );
        pool.execute( new Task() );
        pool.execute( new Task() );
        pool.execute( new Task() );
        pool.execute( new Task() );
        pool.execute( new Task() );
    }
}
class Task implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" do ....");
    }
}
