package com.ren.hao.leetcode.implementStrstr;

/**
 * 创建日期：2019/5/12-20:21
 * 作者：任皓
 * 链接：https://leetcode-cn.com/problems/implement-strstr/
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length()==0)
            return 0;
        int target;

        // 两个字符串从左往右一个个字符挨着比较
        for (int i=0; i<=haystack.length()-needle.length(); i++){
            target = 0;
            for (int j=0; j<needle.length(); j++){
                if (haystack.charAt(i+j) == needle.charAt(j)){
                    target++;
                }else {
                    break;
                }
            }
            if (target==needle.length()){
                return i;
            }
        }
        return -1;
    }
}
