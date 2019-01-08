package com.light;

/**
 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

 示例 1:

 输入: 123
 输出: 321
 示例 2:

 输入: -123
 输出: -321
 示例 3:

 输入: 120
 输出: 21

 */
public class Question7 {
    public static void main(String[] args) {
        Question7 tester = new Question7();
//        System.out.println(tester.reverse(-123));
//        System.out.println(tester.reverse(123));
        System.out.println(tester.reverse(1534236469));//考虑溢出
    }
    public int reverse(int x){
        int result = 0;
        while (x!=0) {
            int tmp = x%10;
            result=result*10+tmp;
            if(result>Integer.MAX_VALUE)return 0;
            x=(x-tmp)/10;

        }
        return result;
    }
}
