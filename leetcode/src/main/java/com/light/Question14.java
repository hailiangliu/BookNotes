package com.light;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**

 编写一个函数来查找字符串数组中的最长公共前缀。

 如果不存在公共前缀，返回空字符串 ""。

 示例 1:

 输入: ["flower","flow","flight"]
 输出: "fl"
 示例 2:

 输入: ["dog","racecar","car"]
 输出: ""
 解释: 输入不存在公共前缀。
 说明:

 所有输入只包含小写字母 a-z 。

 */
public class Question14 {
    public static void main(String[] args) {
        Question14 tester = new Question14();
        String result = tester.longestCommonPrefix(new String[]{"flower","flow","flight"});
//        result = tester.longestCommonPrefix(new String[]{"dog","racecar","car"});
        result = tester.longestCommonPrefix(new String[]{"","b"});
//        result = tester.longestCommonPrefix(new String[]{"a","ac"});
        System.out.println(result);
    }
    public String longestCommonPrefix(String[] strs) {

        List<Character> list = new ArrayList<Character>();

        char[][] chars = new char[strs.length][];
        for (int i = 0; i < strs.length; i++) {
            chars[i]=strs[i].toCharArray();
        }
        for (int i = 0; i < chars.length; i++) {
            char[] tmp = chars[i];
        }
        return getString(list,0,list.size());
    }
    String getString(List<Character> list,int start,int end){
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}
