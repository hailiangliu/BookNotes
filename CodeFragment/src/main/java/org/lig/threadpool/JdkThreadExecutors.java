package org.lig.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JdkThreadExecutors {
    public static void main(String[] args) {

        // 固定10个线程的线程池
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);

        // 一个线程的线程池
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();

        // 无限制（Integer.MAX_VALUE) 的线程池
        // 任务队列采用SynchronousQueue： 阻塞队列， 内部并没有数据缓存空间
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

        ExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(10);
    }
}
