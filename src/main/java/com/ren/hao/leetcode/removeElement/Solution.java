package com.ren.hao.leetcode.removeElement;

/**
 * 创建日期：2019/5/9-22:29
 * 作者：任皓
 * 链接：https://leetcode-cn.com/problems/remove-element/
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length==0)
            return 0;
        else {
            // 记录从左往右不等于val的数的下标
            int left = 0;

            // 记录从右往左不等于val的数的下标
            int right = nums.length-1;

            // 如果要替换时用于暂存数值的变量
            int tmp;
            while (left<=right){
                // 当左右下标所指的共同值等于val时不执行任何操作。
                if (left==right && nums[left]==val)
                    break;
                // 当左下标所指的值等于val的时候
                // 将他与最右面不等于val的值交换
                // 同时left向右移动一个，right指向左边最近的不为val的值的下标
                if (nums[left]==val){
                    tmp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = tmp;
                    right--;
                    while (right>0 && nums[right]==val){
                        right--;
                    }
                }
                left++;
            }
            return left;
        }
    }
}
