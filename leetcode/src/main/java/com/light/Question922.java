package com.light;

import java.util.Arrays;

public class Question922 {
    public static void main(String[] args) {
        Question922 tester = new Question922();
      //  System.out.println(Arrays.toString(tester.sortArrayByParityII(new int[]{4,2,5,7})));
        System.out.println(Arrays.toString(tester.sortArrayByParityII(new int[]{2,3,1,1,4,0,0,4,3,3})));
    }

    public int[] sortArrayByParityII(int[] A) {
        int start=0;
        int end=A.length-1;
        while(start<=end){
            while(start<end){
                if((start%2==0)&&(A[start]%2==0)){
                    start++;
                }else if(start%2!=0 && A[start]%2!=0){
                    start++;
                }else{
                    break;
                }

            }
            while(start<end){
                if(end%2!=0 && A[end]%2!=0){
                    end--;
                }else if(end%2==0 && A[end]%2==0){
                    end--;
                }else{
                    break;
                }
            }
            int tmp = A[start];
            A[start]=A[end];
            A[end]=tmp;
        }
        return A;
    }
}
