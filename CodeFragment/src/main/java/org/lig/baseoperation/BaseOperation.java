package org.lig.baseoperation;

/**
 *
 *
 */
public class BaseOperation {
    public static void main(String[] args) {
        int a = 10 >> 1; // a=5
        int b = a++; // b=5, a=6
        int c = ++a; // c=7, a=7
        int d = b * a++; // a=8, d=35
        int e = b * ++a; // a=9, e= 45
        System.out.println(a);// 9
        System.out.println(b);// 5
        System.out.println(c);// 7
        System.out.println(d);// 35
        System.out.println(e);// 45
    }
}
