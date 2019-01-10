package org.lig.interview;

import java.util.Arrays;

/**
 * 阿里文娱 面试题， 一个数组，从头开始替换，变成后面子数组最大值，最后一位为-1
 * 比如 "3"，"4"，"8"，"12"，"3"
 * 输出 "12"，"12"，"12"，"12"，"-1"
 */
public class ReplaceByAfterMax {

    public static void main(String[] args) {
        ReplaceByAfterMax tester = new ReplaceByAfterMax();
        int[] result = tester.repalce(new int[]{3,16,2,1,15,2});
        System.out.println(Arrays.toString(result));
    }
    public int[] repalce(int[] arrs){
        int len = arrs.length;
        int max=0;
        for (int i = len-1; i >=0; i--) {
            if(i==len-1){
                max=arrs[i];
                arrs[i]=-1;
            }else{
                 int tmp = arrs[i];
                 arrs[i]=max;
                 if(max<tmp) max=tmp;

            }
        }
        return arrs;
    }
}
