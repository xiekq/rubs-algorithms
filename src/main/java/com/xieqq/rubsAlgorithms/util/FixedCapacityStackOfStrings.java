package com.xieqq.rubsAlgorithms.util;

import com.xieqq.rubsAlgorithms.algs4.StdIn;
import com.xieqq.rubsAlgorithms.algs4.StdOut;

public class FixedCapacityStackOfStrings {

    private String[] a;
    private int N;

    public FixedCapacityStackOfStrings(int capacity) {
        a = new String[capacity];
    }

    public String pop() {
        return a[--N];
    }

    public void push(String item) {
        a[N++] = item;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }


    public static void main(String[] args) {
        FixedCapacityStackOfStrings s;
        s = new FixedCapacityStackOfStrings(100);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                s.push(item);
            } else if (!s.isEmpty()) {
                StdOut.print(s.pop() + " ");
            }
        }
        StdOut.println("("+s.size()+" left on stack)");
    }

}
