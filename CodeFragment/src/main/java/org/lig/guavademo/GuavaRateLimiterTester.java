package org.lig.guavademo;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;

public class GuavaRateLimiterTester {

    /**
     * 平滑的处理。
     * @throws InterruptedException
     */
    public static void test() throws InterruptedException {
        /**
         limiter.acquire()表示消费一个令牌，如果当前桶中有足够令牌则成功（返回值为0），
         如果桶中没有令牌则暂停一段时间，比如发令牌间隔是200毫秒，则等待200毫秒后再去消费令牌
         （如上测试用例返回的为0.198239，差不多等待了200毫秒桶中才有令牌可用），
         这种实现将突发请求速率平均为了固定请求速率。如果结构不想等待可以采用tryAcquire立刻返回！
         */
        RateLimiter rateLimiter = RateLimiter.create(5.0);
        Thread.sleep(10000);
        System.out.println(rateLimiter.acquire());
        System.out.println(rateLimiter.acquire());
        System.out.println(rateLimiter.acquire());
        System.out.println(rateLimiter.acquire());
        System.out.println(rateLimiter.acquire());
        System.out.println(rateLimiter.acquire());
        System.out.println(rateLimiter.acquire());
        System.out.println(rateLimiter.acquire());

    }

    public static void testRateLimterTimeout(){
        final RateLimiter rateLimiter = RateLimiter.create(0.5);
        Runnable a = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long time = System.currentTimeMillis();
                boolean result = rateLimiter.tryAcquire(1,2, TimeUnit.SECONDS);
                long end = System.currentTimeMillis();
                System.out.println("抢占耗时："+(end-time));
                if(result){
                    System.out.println("抢占执行了");
                }else{
                    System.out.println("抢不到了，放弃了");
                }
            }
        };
        new Thread(a).start();
        System.out.println(rateLimiter.acquire());
        System.out.println(rateLimiter.acquire());
        System.out.println(rateLimiter.acquire());
        System.out.println(rateLimiter.acquire());
        System.out.println(rateLimiter.acquire());


    }

    public static void main(String[] args) throws InterruptedException {

        GuavaRateLimiterTester.testRateLimterTimeout();
    }

}
