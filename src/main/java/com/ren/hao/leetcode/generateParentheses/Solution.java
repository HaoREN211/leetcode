package com.ren.hao.leetcode.generateParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rWX592490
 * @version 2019/5/9 11:29
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class Solution {
    // 利用递归思想
    private List<String> result = new ArrayList<>();
    private int nb;

    public List<String> generateParenthesis(int n) {
        nb = n;
        add("(", 1, 0);
        return result;
    }

    // left为左扩号的个数，right为右括号的个数
    private void add(String current, int left, int right){
        // 如果左右括号数量都等于n的时候符合条件，将此时的字符串添加到结果中
        if (left==nb && right==nb){
            result.add(current);
        }
        // 如果左边的括号数小于n，则此时还可以添加左括号
        if (left<nb){
            add(current+'(', left+1, right);
        }
        // 如果右边的括号数小于n和左边的括号数，此时可以添加右括号 
        if (right<nb && right<left){
            add(current+')', left, right+1);
        }
    }
}
