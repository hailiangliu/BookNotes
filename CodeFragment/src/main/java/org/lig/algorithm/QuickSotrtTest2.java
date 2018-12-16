package org.lig.algorithm;

import java.util.Arrays;

/*好理解一些
 */
public class QuickSotrtTest2 {

    public static void main(String[] args) {
        int[] arrs = {99,28,34,1,4,6,22,61,5,44,46,15,27,43,86,33,42,1,14,6,9,61,54,63,207,99,1,85,49,36,72,51,18,50,388};
        System.out.println(Arrays.toString(arrs));

        // 把代排序列分两组，保证两组一边大一边小，并得到分组的index
        QuickSotrtTest2.qSort(arrs,0,arrs.length-1);
        System.out.println("2");
        System.out.println(Arrays.toString(arrs));

    }

    public static void qSort(int[] arrs, int low, int high){
       if(low<high){
           int idx = part(arrs,low,high);
           qSort(arrs,low,idx-1);
           qSort(arrs,idx+1,high);
       }

    }
    public static int part(int[] arrs, int low, int high){
        int startIdx = low;

        int compVal = arrs[low];
        while(low<high){
            while(compVal>=arrs[high]&&low<high){//降序
                high--;
            }
            while(compVal<=arrs[low]&&low<high){
                low++;
            }
            if(low<high)
                swap(arrs, low, high);
        }
        swap(arrs, startIdx, low);


        return low;

    }

    public static void swap(int[] src, int i, int j){
        int temp = src[i];
        src[i]=src[j];
        src[j]=temp;
    }
}
