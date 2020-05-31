package com.xieqq.rubsAlgorithms.leetcode.learn.linkedList;

/**
 * @description: leetcode-链表基本实现
 * @author: xiekekqing
 * @create: 2020-05-18 19:28
 **/
public class MyLinkedList{

    private ListNode head = null;
    private ListNode tail = null;
    private int N;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
    }

    /**
     * Check is empty of the linked list.
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * Get size of the linked list.
     */
    public int size() {
        return N;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= N) {
            return -1;
        }
        ListNode temp = head;
        while (--index >= 0) {
            temp = temp.next;
        }
        return temp.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        ListNode oldHead = head;
        head = new ListNode();
        head.val = val;
        head.next = oldHead;
        if (isEmpty()) {
            tail = head;
        }
        N++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        ListNode oldTail = tail;
        tail = new ListNode();
        tail.val = val;
        if (oldTail == null) {
            head = tail;
        } else {
            oldTail.next = tail;
        }
        N++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > N) {
            return;
        }
        if (0 == index) {
            addAtHead(val);
            return;
        }

        ListNode preNode = head;
        while (--index > 0) {
            preNode = preNode.next;
        }
        ListNode node = new ListNode();
        node.val = val;
        node.next = preNode.next;
        if (null == preNode.next) {
            tail = node;
        }
        preNode.next = node;
        N++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= N) {
            return;
        }

        if (0 == index) {
            head = head.next;
            N--;
            if (isEmpty()) {
                tail = head;
            }
        } else {
            ListNode preNode = head;
            while (--index > 0) {
                preNode = preNode.next;
            }
            //delete tail
            preNode.next = preNode.next.next;
            if (null == preNode.next) {
                tail = preNode;
            }
            N--;
        }
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList(); // Initialize empty LinkedList
        linkedList.addAtHead(7);
        linkedList.addAtHead(2);
        linkedList.addAtHead(1);
        linkedList.addAtIndex(3,0);
        linkedList.deleteAtIndex(2);
        linkedList.addAtHead(6);
        linkedList.addAtTail(4);
        linkedList.get(4);
        linkedList.addAtHead(4);
        linkedList.addAtIndex(5,0);
        linkedList.addAtHead(6);
    }

}
