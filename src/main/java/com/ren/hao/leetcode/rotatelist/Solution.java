package com.ren.hao.leetcode.rotatelist;

/**
 * 创建日期：2019/5/9-21:37
 * 作者：任皓
 * 链接：
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // 先排除空链表的干扰
        if (head==null || head.next == null)
            return head;

        // 计算链表的长度
        int length = 1;
        ListNode current = head;
        while (current.next!=null){
            length++;
            current = current.next;
        }

        // 计算实际有偏差的位移
        int nbIteration = k%length;

        // 进行替换
        current = head;
        ListNode before=current;
        for (int i=0; i<nbIteration; i++){
            head = current;
            while (current.next!=null){
                before = current;
                current = current.next;
            }
            current.next=head;
            before.next=null;
        }
        return current;
    }
}
