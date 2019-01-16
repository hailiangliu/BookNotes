package org.lig.jdkthreadpool;

import java.util.concurrent.*;

public class TestRejectPolicy {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1,1,10000,
                TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>(1),new ThreadPoolExecutor.CallerRunsPolicy());


        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            Runnable myrun = new Runnable() {
                @Override
                public void run() {
                    System.out.println("task-" + finalI);
                }
            };
            pool.execute(myrun);
        }

    }
}
