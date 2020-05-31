package com.xieqq.rubsAlgorithms.leetcode.learn.linkedList;

/**
 * @description: 单链表反转
 * @author: xiekekqing
 * @create: 2020-05-25 13:17
 **/
public class SolutionReverseLinkList {

    public ListNode reverseList(ListNode head){
        if(null == head || null == head.next){
            return head;
        }

        ListNode P = head;

        //哨兵节点
        ListNode serHead = new ListNode(-1);
        serHead.next = head;

        while (P.next != null){
            ListNode temp = P.next;
            P.next = P.next.next;
            temp.next = serHead.next;
            serHead.next = temp;
        }

        return serHead.next;
    }
}
