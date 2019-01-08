package com.light;

import java.util.Queue;

/**
 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。


 */
public class Question693 {
    public static void main(String[] args) {
        Question693 tester = new Question693();
        int val=2;
        System.out.println(Integer.toBinaryString(val));
        boolean result = tester.hasAlternatingBits(val);
        System.out.println(result);
    }
    public boolean hasAlternatingBits(int n) {

        int last = 0;
        while(n>=0){

            if(last==(n&(n+1))){
                return false;
            }
            last = n&1;
            n=n>>1;
        }
        return true;

    }
}
