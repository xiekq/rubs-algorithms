package com.xieqq.rubsAlgorithms.leetcode.learn.linkedList;

/**
 * @description: 删除给定值的节点
 * @author: xiekekqing
 * @create: 2020-05-25 20:01
 **/
public class SolutionRemoveElements {
    public ListNode removeElements(ListNode head, int val) {

        if (null == head) {
            return null;
        }

        ListNode sentinelHeadNode = new ListNode(-1);
        sentinelHeadNode.next = head;

        ListNode temp = sentinelHeadNode;
        while (null != temp) {
            if (null == temp.next) {
                break;
            }
            if (temp.next.val != val) {
                temp = temp.next;
            } else {
                temp.next = temp.next.next;
            }
        }
        return sentinelHeadNode.next;
    }
}
