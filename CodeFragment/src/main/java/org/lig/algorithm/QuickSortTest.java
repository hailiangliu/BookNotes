package org.lig.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSortTest {





    public static void main(String[] args) {
        int[] arrs = {99,28,34,1,4,6,22,61,5,44,46,15,27,43,86,33,42,1,14,6,9,61,54,63,207,99,1,85,49,36,72,51,18,50,388};
        //QuickSortTest.test(arrs);
        //System.out.println(Arrays.toString(arrs));


        // 把代排序列分两组，保证两组一边大一边小，并得到分组的index
        QuickSortTest.qSort(arrs,0,arrs.length-1);
        System.out.println("1");
        System.out.println(Arrays.toString(arrs));

    }
    public static void test(int[] arrs){
        int temp = arrs[0];
        arrs[0]=arrs[1];
        arrs[1]=temp;
    }

    public static void qSort(int[] arrs, int low, int high){

        int p ;
        if(low<high){
            p = partition(arrs,low,high);
            qSort(arrs,low,p-1);
            qSort(arrs,p+1,high);
        }
    }


    public static void swap(int[] src, int i, int j){
        int temp = src[i];
        src[i]=src[j];
        src[j]=temp;
    }
    public static int partition(int[] arrs, int low, int high){
        int value = arrs[low];// 选取第一个位置的值为比较值ß
        while(low<high){
            while(low<high && value>=arrs[high]){
                high--;
            }
            swap(arrs,low,high);
            while(low<high && arrs[low]>=value){
                low++;
            }
            swap(arrs,low,high);

        }
        return low;
    }


}
