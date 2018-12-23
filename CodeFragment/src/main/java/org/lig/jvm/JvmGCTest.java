package org.lig.jvm;

public class JvmGCTest {
    /**
     * -verbose:gc -Xms20M -Xmx20M -Xmn5M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * @param args
     */

    public static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] a1,a2,a3,a4;
        a1=new byte[2*_1MB];
        a2=new byte[2*_1MB];
        a3=new byte[6*_1MB];
        //a4=new byte[2*_1MB];
        System.out.println("finish");
    }
}
