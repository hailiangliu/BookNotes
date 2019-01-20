package com.light;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class Question283 {
    public static void main(String[] args) {
        Question283 tester = new Question283();
        //System.out.println(Arrays.toString(tester.moveZeroes(new int[]{0,1,0,3,12})));
        System.out.println(Arrays.toString(tester.swap(new int[]{1,2,3,4,5,6,7,8,9})));
    }
    public int[] moveZeroes(int[] nums) {
        int zeroNum=0;//用来计算0的个数
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){//如果nums[i]=0,zeroNum个数加一
                zeroNum++;
            }else if(zeroNum!=0){//如果nums[i]不等于0,将nums[i]跟前zeroNum个交换，并且将nums[i]赋值为0
                nums[i-zeroNum]=nums[i];
                nums[i]=0;
            }
        }
        return nums;
    }
    public int[] swap(int[] nums){
        int i=0;
        int j=nums.length-1;
        while(i<j){
            while(nums[i]%2==0&&i<j){
                i++;
            }
            while(nums[j]%2==1&&i<j){
                j--;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
        return nums;
    }
}
