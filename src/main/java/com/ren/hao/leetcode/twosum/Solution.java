package com.ren.hao.leetcode.twosum;

/**
 * 创建日期：2019/5/9-21:38
 * 作者：任皓
 * 链接：
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int length = nums.length;

        if (length<2)
            return result;

        for (int i = 0; i<length; i++){
            for (int j = i+1; j<length;j++){
                if (nums[i]+nums[j]==target){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }

        return result;
    }
}
