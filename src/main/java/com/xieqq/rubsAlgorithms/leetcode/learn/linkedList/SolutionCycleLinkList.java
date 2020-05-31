package com.xieqq.rubsAlgorithms.leetcode.learn.linkedList;

/**
 * @description: 判断链表是否有环
 * @author: xiekekqing
 * @create: 2020-05-19 20:04
 **/
public class SolutionCycleLinkList {

        public boolean hasCycle(ListNode head) {
            if (null == head || null == head.next) {
                return false;
            }
            ListNode stepOneNode = head;
            ListNode stepTwoNode = head;
            while (null != stepTwoNode && null != stepTwoNode.next) {
                stepOneNode = stepOneNode.next;
                stepTwoNode = stepTwoNode.next.next;
                if (null != stepTwoNode && stepOneNode == stepTwoNode) {
                    return true;
                }
            }
            return false;
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
//
//        Solution solution = new Solution();
//        System.out.println(solution.hasCycle(head));

//        head.next = second;
//        second.next = head;

        SolutionCycleLinkList solution = new SolutionCycleLinkList();
        System.out.println(solution.hasCycle(head));

    }

}
