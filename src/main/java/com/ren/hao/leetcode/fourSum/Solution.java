package com.ren.hao.leetcode.fourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author rWX592490
 * @version 2019/5/9 9:27
 * https://leetcode-cn.com/problems/4sum/
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 和计算三数之和类似
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        int left;
        int right;
        int tmpTwoSum;
        int tmpFourSum;

        // 循环首未数字
        for (int i=0; i<nums.length-3; i++){
            while (i>0 && nums[i]==nums[i-1]) i++;
            for (int j=nums.length-1; j>2; j--){
                while (j<nums.length-1 && nums[j]==nums[j+1]) j--;
                tmpTwoSum = nums[i] + nums[j];
                left = i+1;
                right = j-1;

                // 然后遍历首未之间的数字
                while (left<right){
                    System.out.println(i+" -> "+left+" -> "+right+" -> "+j);
                    tmpFourSum = tmpTwoSum + nums[left] + nums[right];
                    if (tmpFourSum==target){
                        result.add(Arrays.asList(nums[i], nums[left], nums[right], nums[j]));
                        while (left<right && nums[left]==nums[left+1]) left++;
                        left++;
                        while (left<right && nums[right]==nums[right-1]) right--;
                        right--;
                    }
                    if (tmpFourSum<target){
                        while (left<right && nums[left]==nums[left+1]) left++;
                        left++;
                    }
                    if (tmpFourSum>target){
                        while (left<right && nums[right]==nums[right-1]) right--;
                        right--;
                    }
                }
            }
        }

        return result;
    }
}
