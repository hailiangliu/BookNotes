package com.light;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class Question9 {
    public static void main(String[] args) {
        Question9 tester = new Question9();
        System.out.println(tester.isPalindrome2(10));
        System.out.println(tester.isPalindrome2(-121));
        System.out.println(tester.isPalindrome2(1));
        System.out.println(tester.isPalindrome2(121));
        System.out.println(tester.isPalindrome2(121));
    }
    // 第一种转字符串做法
    public boolean isPalindrome(int x) {
        String str = x + "";
        char[] chars = str.toCharArray();
        int a = 0;
        int b=chars.length-1;
        while(a<=b){
            if(chars[a]!=chars[b]){
                return false;
            }
            a++;
            b--;
        }
        return true;
    }
    //第二种进阶
    public boolean isPalindrome2(int x) {

        if(x<0||(x%10==0&&x!=0)) return false;

        int tmp = 0;
        while(x>=tmp){
            tmp = tmp*10+x%10;
            x=x/10;
        }
        if(tmp==x||x==tmp/10){
            return true;
        }
        return false;
    }
}
