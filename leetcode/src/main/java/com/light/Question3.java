package com.light;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

 示例 1:

 输入: "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 示例 2:

 输入: "bbbbb"
 输出: 1
 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 示例 3:

 输入: "pwwkew"
 输出: 3
 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Question3 {
    public static void main(String[] args) {
        // 没做出来
    }

    public int lengthOfLongestSubstring(String s) {
       return lengthOfSubstring(s,0,0);



    }


    public int lengthOfSubstring(String s, int startIndex,int maxSize){
        char[] chars = s.toCharArray();

        HashSet map = new HashSet();
        for (int i = startIndex; i < chars.length; i++) {
            char c = chars[i];
            if (map.contains(c)){
                break;
            }else{
                map.add(c);
            }
        }
        return map.size()>=maxSize?map.size():maxSize;
    }
}
