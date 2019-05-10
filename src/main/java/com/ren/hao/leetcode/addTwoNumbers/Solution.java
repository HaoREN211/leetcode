package com.ren.hao.leetcode.addTwoNumbers;

/**
 * 创建日期：2019/5/9-21:34
 * 作者：任皓
 * 链接：https://leetcode-cn.com/problems/add-two-numbers/
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean plusTen = false;
        int sum;
        ListNode headNode = new ListNode(0);
        ListNode currentNode = headNode;
        ListNode remainderNode;
        ListNode previousNode = headNode;
        while (l1 != null && l2!=null){
            // 两个数字从左到右挨个相加
            sum = l1.val + l2.val;

            // 如果前面两个数字之和大于10，则进位
            if (plusTen){
                sum += 1;
            }

            // 如果当前两个数字之和大于10，则该位数取余并标记进位
            if (sum>=10){
                plusTen = true;
                sum = sum%10;
            }
            else{
                plusTen = false;
            }

            currentNode.val = sum;
            currentNode.next = new ListNode(0);
            previousNode = currentNode;
            currentNode = currentNode.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        // 如果l1和l2长度相同则不需要单独再对l1和l2剩余的节点进行处理
        if (l1 == null && l2 ==null){
            remainderNode = null;
        }
        // 如果l2的长度大于l1，则需要把l2剩下的节点全部加进来
        else if (l1 ==null){
            remainderNode = l2;
        }
        // 如果l1的长度大于l2，则需要把l1剩下的节点全部加进来
        else{
            remainderNode = l1;
        }

        while (remainderNode != null){
            sum = remainderNode.val;
            if (plusTen){
                sum += 1;
            }

            if (sum>=10){
                plusTen = true;
                sum = sum%10;
            }
            else{
                plusTen = false;
            }

            currentNode.val = sum;
            currentNode.next = new ListNode(0);
            previousNode = currentNode;
            currentNode = currentNode.next;
            remainderNode = remainderNode.next;
        }

        // 如果最右边的数即最高位仍然有进位（大于10），则需要在末尾再加上一个值为1的节点
        if (plusTen){
            currentNode.val = 1;
        }else{
            previousNode.next = null;
        }
        return headNode;
    }
}
