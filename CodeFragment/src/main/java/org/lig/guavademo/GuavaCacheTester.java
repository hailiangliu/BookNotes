package org.lig.guavademo;

import com.google.common.cache.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class GuavaCacheTester {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        LoadingCache<String, Object> cache = CacheBuilder.newBuilder()
                .maximumSize(3)
                .removalListener(new RemovalListener<Object, Object>() {
                    @Override
                    public void onRemoval(RemovalNotification<Object, Object> notification) {
                        System.err.println("removed:key="+notification.getKey()+",val="+notification.getValue()+", cause:"+notification.getCause().toString());
                    }
                })
                .expireAfterAccess(3, TimeUnit.SECONDS)
                .build(new CacheLoader<String, Object>() {
                    @Override
                    public Object load(String key) throws Exception {
                        return key+"-value";
                    }
                });
        System.out.println(cache.get("sbcd"));
        Thread.sleep(10000);
//        System.out.println(cache.get("sbcd"));
    }

}
