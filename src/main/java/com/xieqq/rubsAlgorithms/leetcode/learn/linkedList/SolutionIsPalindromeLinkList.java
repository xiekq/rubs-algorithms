package com.xieqq.rubsAlgorithms.leetcode.learn.linkedList;

/**
 * @description: 判断链表是否对称链表
 * @author: xiekekqing
 * @create: 2020-05-25 20:01
 **/
public class SolutionIsPalindromeLinkList {
    public boolean isPalindrome(ListNode head) {
        if (null == head || null == head.next) {
            return true;
        }
        //两个节点直接检查
        if (null == head.next.next) {
            return head.val == head.next.val;
        }

        ListNode quickNode = head.next.next;
        ListNode slowNode = head.next;
        ListNode slowPreNode = head;
        boolean isComparing = false;
        while (null != slowNode) {
            if (null != quickNode && null != quickNode.next) {
                quickNode = quickNode.next.next;

                //链表反转
                slowPreNode.next = slowNode.next;
                slowNode.next = head;
                head = slowNode;
                slowNode = slowPreNode.next;
            } else {
                //首次交换
                if (!isComparing) {
                    //节点个数为奇数
                    if (null != quickNode) {
                        slowNode = slowNode.next;
                    }
                    isComparing = true;
                }

                if (head.val != slowNode.val) {
                    return false;
                }
                head = head.next;
                slowNode = slowNode.next;
            }
        }
        return true;
    }
}
