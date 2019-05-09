package com.ren.hao.leetcode.removeDuplicatesFromSortedArray;

/**
 * 创建日期：2019/5/9-21:57
 * 作者：任皓
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length==0)
            return 0;
        else {
            // 使用两个记录下标的整形变量
            // 第一个length记录当前循环遇见的不重复的数字的个数
            // 第二个i记录当前循环遇见的数
            // 如果当前的数与前面的数相同则忽略该数，比较下一个数字
            // 否则记录该数
            int length = 1;
            for (int i = 1; i<nums.length; i++){
                while (i<nums.length && nums[i]==nums[i-1]){
                    i++;
                }
                if (i<nums.length){
                    nums[length]=nums[i];
                    length++;
                }
            }
            return length;
        }
    }
}
