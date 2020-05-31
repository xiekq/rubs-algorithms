package com.xieqq.rubsAlgorithms.util;

import com.xieqq.rubsAlgorithms.algs4.StdIn;
import com.xieqq.rubsAlgorithms.algs4.StdOut;

import java.util.Iterator;

/**
 * @description: 背包
 * @author: xiekekqing
 * @create: 2020-05-30 10:02
 **/
public class Bag<Item> implements Iterable<Item> {

    private Node head;
    private int N;

    public Bag() {
    }

    private class Node {
        Item item;
        Node next;
    }

    public void add(Item item) {
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
        Bag<String> s;
        s = new Bag();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            s.add(item);
        }

        StdOut.println("(bag size is " + s.size() + ")");
        Iterator iterator = s.iterator();

        StdOut.print("(bag items is : ");
        while (iterator.hasNext()) {
            StdOut.print(iterator.next() + " ");
        }
        StdOut.print(")");
    }
}
