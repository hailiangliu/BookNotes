package com.light;

import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class Question66 {

    public static void main(String[] args) {
        Question66 tester = new Question66();
        System.out.println(Arrays.toString(tester.plusOne(new int[]{1,2,3})));
        System.out.println(Arrays.toString(tester.plusOne(new int[]{4,3,2,1})));
        System.out.println(Arrays.toString(tester.plusOne(new int[]{1})));
        System.out.println(Arrays.toString(tester.plusOne(new int[]{9})));
        System.out.println(Arrays.toString(tester.plusOne(new int[]{9,9})));
        System.out.println(Arrays.toString(tester.plusOne(new int[]{8,9,9,9})));


    }
    public int[] plusOne(int[] nums){
        boolean pop = false;

        int val = nums[nums.length-1] + 1;
        if(val>=10){
            pop=true;
            nums[nums.length-1]=(val-10);
            if(nums.length==1){
                return new int[]{1,nums[0]};
            }
            for(int i=nums.length-2;i>=0;i--){
                int tmp = nums[i]+(pop?1:0);
                if(tmp>=10){
                    pop=true;
                    nums[i]=tmp-10;
                }else{

                    nums[i]=tmp;
                    pop=false;
                }
            }
            if(pop){
                int[] result = new int[nums.length+1];
                System.arraycopy(nums,0,result,1,nums.length);
                result[0]=1;
                return result;
            }
            return nums;

        }else{
            nums[nums.length-1]=val;
            return nums;
        }
    }

}
