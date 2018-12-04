# java中Collections.sort的原理
## Collection和Collections区别
    1 java.util.Collection是一个集合接口。
    2 java.util.Collections是集合帮助类，提供一些集合的搜索、排序、线程安全等操作
    
 ## Arrays.sort
    Collections.sort底层也是调用的Arrays.sort方法
```java
    public static <T> void sort(T[] a, Comparator<? super T> c) {
            if (c == null) {
                sort(a);
            } else {
                if (LegacyMergeSort.userRequested)
                    legacyMergeSort(a, c);
                else
                    TimSort.sort(a, 0, a.length, c, null, 0, 0);
            }
    }
        
    public static void sort(Object[] a) {
        if (LegacyMergeSort.userRequested)
            legacyMergeSort(a);
        else
            ComparableTimSort.sort(a, 0, a.length, null, 0, 0);
    }
```
    legacyMergeSort(a)：归并排序
    ComparableTimSort.sort()：Timsort排序