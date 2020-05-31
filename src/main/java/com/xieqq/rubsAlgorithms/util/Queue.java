package com.xieqq.rubsAlgorithms.util;

import com.xieqq.rubsAlgorithms.algs4.StdIn;
import com.xieqq.rubsAlgorithms.algs4.StdOut;

import java.util.Iterator;

/**
 * @description: 队列
 * @author: jay
 * @create: 2020-05-30 10:06
 **/
public class Queue<Item> implements Iterable {

    private Node head;
    private Node tail;
    private int N;

    public Queue() {
    }

    private class Node {
        Item item;
        Node next;
    }

    public Item dequeue() {
        if (isEmpty()) {
            return null;
        }
        Item item = head.item;
        head = head.next;
        N--;
        if (isEmpty()) {
            tail = head;
        }
        return item;
    }

    public void enqueue(Item item) {
        Node oldTail = tail;
        tail = new Node();
        tail.item = item;
        if (isEmpty()) {
            head = tail;
        } else {
            oldTail.next = tail;
        }
        N++;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public Iterator iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator {
        private Node current = head;
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            i--;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        Queue<String> s;
        s = new Queue();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                s.enqueue(item);
            } else if (!s.isEmpty()) {
                StdOut.print(s.dequeue() + " ");
            }
        }

        StdOut.println("(queue size is " + s.size() + ")");
        Iterator iterator = s.iterator();

        StdOut.print("(queue items is : ");
        while (iterator.hasNext()) {
            StdOut.print(iterator.next() + " ");
        }
        StdOut.print(")");
    }

}
