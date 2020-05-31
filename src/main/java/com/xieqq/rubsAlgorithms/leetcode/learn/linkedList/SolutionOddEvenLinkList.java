package com.xieqq.rubsAlgorithms.leetcode.learn.linkedList;

/**
 * @description: 奇偶链表
 * @author: xiekekqing
 * @create: 2020-05-25 20:01
 **/
public class SolutionOddEvenLinkList {

    public ListNode oddEvenList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode oddTail = head;
        ListNode evenHead = head.next, evenTail = head.next;

        while (null != oddTail.next && null != evenTail.next) {
            oddTail.next = oddTail.next.next;
            oddTail = oddTail.next;
            evenTail.next = evenTail.next.next;
            evenTail = evenTail.next;

        }
        oddTail.next = evenHead;
        return head;
    }

}
