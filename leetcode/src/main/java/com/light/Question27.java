package com.light;

import java.util.Arrays;

/**
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 1:
 *
 * 给定 nums = [3,2,2,3], val = 3,
 *
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 *
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 *
 * 注意这五个元素可为任意顺序。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class Question27 {
    public static void main(String[] args) {
        Question27 tester = new Question27();
        int[] nums = new int[]{3,2,2,3};
        int val=3;
//        System.out.println(tester.removeElement(nums,val)+(Arrays.toString(nums)));
//
//        nums = new int[]{0,1,2,2,3,0,4,2};
//        val=2;
//        System.out.println(tester.removeElement(nums,val)+(Arrays.toString(nums)));

        nums = new int[]{3,4};
        val=3;
        System.out.println(tester.removeElement(nums,val)+(Arrays.toString(nums)));

    }
    public int removeElement(int[] nums , int val){

        int j = nums.length-1;
        //if(j<0) return 0;
        int i = 0;

        while (i < j) {
            while (i!=j&&nums[i]!=val){
                i++;
            }
            if(i!=j&&nums[j]==val){
                j--;
            }
            int tmp = nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;

        }

        return i;
    }
}
