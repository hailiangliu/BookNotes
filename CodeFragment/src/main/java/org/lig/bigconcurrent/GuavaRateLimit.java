package org.lig.bigconcurrent;

import com.google.common.util.concurrent.RateLimiter;

public class GuavaRateLimit {

    public static void main(String[] args) throws InterruptedException {
        GuavaRateLimit tester = new GuavaRateLimit();

        int tryCount = 10;
        int c = 0;
        while (true){
            if(tester.tryAquire()){
                System.out.println("可以处理");
                Thread.currentThread().sleep(50);
            }else{
                System.err.println("被限制了");
            }
            System.out.println("当前执行次数"+c++);
            if(c>tryCount)break;
        }
        System.out.println("测试结束");
    }

    private RateLimiter rateLimiter = RateLimiter.create(5.0);
    public boolean tryAquire(){
        return rateLimiter.tryAcquire();
    }
}

