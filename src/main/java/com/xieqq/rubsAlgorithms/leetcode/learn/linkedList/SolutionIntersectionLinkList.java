package com.xieqq.rubsAlgorithms.leetcode.learn.linkedList;

/**
 * @description: 单向链表交叉
 * @author: xiekekqing
 * @create: 2020-05-21 20:09
 **/
public class SolutionIntersectionLinkList {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //只要有一个节点的则不会交叉
        if (null == headA || null == headB || null == headA.next || null == headB.next) {
            return null;
        }

        //遍历其中一个链表
        ListNode nodePA = headA;
        ListNode nodePB = headB;

        int nodeALen = 0;
        int nodeBLen = 0;
        int index = 0;
        while (true) {
            if ((nodeALen > 0 && nodeBLen > 0) && index > (nodeALen + nodeBLen)) {
                break;
            }
            if (nodePA.val == nodePB.val) {
                return nodePA;
            }
            if (null == nodePA.next) {
                nodeALen = index;
                nodePA = headB;
            } else {
                nodePA = nodePA.next;
            }

            if (null == nodePB.next) {
                nodeBLen = index;
                nodePB = headA;
            } else {
                nodePB = nodePB.next;
            }
            index++;
        }
        System.out.println(index);
        return null;
    }

    public static void main(String[] args) {
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        ListNode n9 = new ListNode(9);
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;

        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;

        ListNode resultNode = getIntersectionNode(n3, n1);
        if(null == resultNode){
            System.out.println(-1);

        }else{
            System.out.println(getIntersectionNode(n3, n1).val);
        }

    }

}
