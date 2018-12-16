package org.lig.algorithm;

import java.util.Arrays;

public class QuickSort3 {
    public static void main(String[] args) {
        int[] arrs = {99,28,34,1,4,6,22,61,5,44,46,15,27,43,86,33,42,1,14,6,9,61,54,63,207,99,1,85,49,36,72,51,18,50,388};
        System.out.println(Arrays.toString(arrs));
        QuickSort3.quickSort(arrs,0,arrs.length-1);
        System.out.println("333");
        System.out.println(Arrays.toString(arrs));
    }
    public static void quickSort(int[] arrs, int low, int high){

        if(low>high) return;


        int idx = part(arrs,low,high);

        System.out.println(Arrays.toString(arrs));
        quickSort(arrs,low,idx-1);
        quickSort(arrs,idx+1,high);

    }

    public static int part(int[] arrs, int low, int high){
        int compValueIdx = low;
        int compValue = arrs[compValueIdx];
        while(low<high) {
            while(compValue>=arrs[high] && low<high){
                high--;
            }
            while(compValue<=arrs[low]&& low<high){
                low++;
            }
            int temp = arrs[low];
            arrs[low]=arrs[high];
            arrs[high]=temp;
        }
        arrs[compValueIdx]=arrs[low];
        arrs[low]=compValue;
        return low;
    }
}
