package com.xieqq.rubsAlgorithms.leetcode.learn.linkedList;

/**
 * @description: 单向链表交叉
 * @author: xiekekqing
 * @create: 2020-05-21 20:09
 **/
public class SolutionIntersectionLinkList {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //只要有一个节点的则不会交叉
        if (null == headA || null == headB) {
            return null;
        }
        if(headA == headB){
            return headA;
        }

        //遍历其中一个链表
        ListNode tempA = headA, tempB = headB;
        ListNode tailA = null,tailB = null;

        while (tempA != tempB) {
            if ((tailB != null && tailA != null) && tempA == tailB) {
                return null;
            }
            if (null == tempA.next) {
                tailA = tempA;
                tempA = headB;
            } else {
                tempA = tempA.next;
            }
            if (null == tempB.next) {
                tailB = tempB;
                tempB = headA;
            } else {
                tempB = tempB.next;
            }
        }

        return tempA;
    }

    public static void main(String[] args) {


        ListNode n8 = new ListNode(8);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n8.next = n4;
        n4.next = n5;

        ListNode a4 = new ListNode(4);
        ListNode a1 = new ListNode(1);
        a4.next = a1;
        a1.next = n8;


        ListNode b5 = new ListNode(5);
        ListNode b0 = new ListNode(0);
        ListNode b1 = new ListNode(1);
        b5.next = b0;
        b0.next = b1;
        b1.next = n8;

        ListNode resultNode = getIntersectionNode(a4, b5);
        if (null == resultNode) {
            System.out.println(-1);

        } else {
            System.out.println(resultNode.val);
        }

    }

}
