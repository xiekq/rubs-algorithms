package com.xieqq.rubsAlgorithms.leetcode.learn.linkedList;

import com.xieqq.rubsAlgorithms.algs4.StdOut;

/**
 * @description: 获取有环链表的入口元素
 * @author: xiekekqing
 * @create: 2020-05-20 16:03
 **/
public class SolutionCycleLinkList2 {

    public ListNode detectCycle(ListNode head) {
        if (null == head || null == head.next) {
            return null;
        }

        ListNode slowNode = head;
        ListNode fastNode = head;
        while (null != fastNode && null != fastNode.next) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (null != fastNode && slowNode == fastNode) {
                break;
            }
        }
        if (null == fastNode || null == fastNode.next) {
            return null;
        }

        ListNode surveyNode = head;
        while (surveyNode != slowNode) {
            surveyNode = surveyNode.next;
            slowNode = slowNode.next;
        }
        return surveyNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode four = new ListNode(-4);

        head.next = second;
        second.next = third;
        third.next = four;
        four.next = second;

        SolutionCycleLinkList2 solutionLinkCycle2 = new SolutionCycleLinkList2();
        ListNode node = solutionLinkCycle2.detectCycle(head);
        StdOut.println(node.val);
    }


}

