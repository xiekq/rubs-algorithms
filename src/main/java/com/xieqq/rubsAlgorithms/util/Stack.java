package com.xieqq.rubsAlgorithms.util;

import com.xieqq.rubsAlgorithms.algs4.StdIn;
import com.xieqq.rubsAlgorithms.algs4.StdOut;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {

    private Node head;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public Stack() {
    }

    public Item pop() {
        if (head != null) {
            Item item = head.item;
            head = head.next;
            N--;
            return item;
        }
        return null;
    }

    public void push(Item item) {
        Node oldHead = head;
        head = new Node();
        head.item = item;
        head.next = oldHead;
        N++;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public Iterator<Item> iterator() {
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
        Stack<String> s;
        s = new Stack();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                s.push(item);
            } else if (!s.isEmpty()) {
                StdOut.print(s.pop() + " ");
            }
        }

        StdOut.println("(stack size is " + s.size() + ")");
        Iterator iterator = s.iterator();

        StdOut.print("(stack items is : ");
        while (iterator.hasNext()) {
            StdOut.print(iterator.next() + " ");
        }
        StdOut.print(")");
    }

}
