package com.ren.hao.leetcode.divideTwoIntegers;

/**
 * 创建日期：2019/5/12-21:59
 * 作者：任皓
 * 链接：
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        boolean isSame = (dividend>0 && divisor>0) || (dividend<0 && divisor<0);
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int result = add(dividend, divisor);
        if (isSame)
            return result;
        else
            return -result;
    }

    private int add(int divident, int divisor){
        if (divident<divisor)
            return 0;
        else
            return 1+add(divident-divisor, divisor);
    }
}
