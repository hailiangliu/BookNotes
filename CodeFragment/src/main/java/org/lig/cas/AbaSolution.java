package org.lig.cas;

import java.util.concurrent.atomic.AtomicReference;

public class AbaSolution {
    public static void main(String[] args) {
        String initString = "initString";
        AtomicReference<String> reference = new AtomicReference<String>(initString);
        String updateString ="updateString";

        System.out.println("值="+reference.get());

        boolean result = reference.compareAndSet(initString,updateString);
        System.out.println("第1次更新="+result);
        System.out.println("值="+reference.get());

        boolean result2 = reference.compareAndSet(updateString,initString);
        System.out.println("第2次更新="+result2);
        System.out.println("值="+reference.get());

        boolean result3 = reference.compareAndSet("",updateString);
        System.out.println("第3次更新="+result3);
        System.out.println("值="+reference.get());

    }
}
