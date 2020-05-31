package com.xieqq.rubsAlgorithms.leetcode.learn.linkedList;

/**
 * @description: 删除倒数第N个节点
 * @author: xiekekqing
 * @create: 2020-05-22 12:59
 **/
public class SolutionRemoveNthLinkNode {

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode oneNode = head;
        ListNode secondNode = head;
        int range = 0;
        while (true) {
            if(null == secondNode.next){
                if(range < n-1){
                    return  head;
                }else if(range == n-1){
                    return oneNode.next;
                }else{
                    oneNode.next = oneNode.next.next;
                    return head;
                }
            }

            if (range == n) {
                oneNode = oneNode.next;
            }
            secondNode = secondNode.next;
            if (range < n) {
                range++;
            }

        }

    }

    public static void main(String[] args) {
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        ListNode n9 = new ListNode(9);
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;

        ListNode resultNode = removeNthFromEnd(n6,3);
        System.out.println(resultNode.val);
    }

}
