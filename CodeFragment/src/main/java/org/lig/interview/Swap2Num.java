package org.lig.interview;

public class Swap2Num {
    public static void main(String[] args) {
        int a =100;
        int b =200;

        a=a^b;
        b=a^b;
        a=a^b;
        System.out.println(a);
        System.out.println(b);

        int x=10;
        int y=20;
        y=x^y^y;
        x=x^y^x;
        System.out.println(x);
        System.out.println(y);

        int i=1;
        System.out.println(i+++i++);

    }
}
