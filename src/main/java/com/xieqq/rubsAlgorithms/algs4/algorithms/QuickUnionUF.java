package com.xieqq.rubsAlgorithms.algs4.algorithms;

import com.xieqq.rubsAlgorithms.algs4.StdOut;

public class QuickUnionUF implements QuickUF {

    private int[] a;
    private int count;

    public QuickUnionUF(int[] a) {
        this.a = a;
        count = a.length;
    }


    @Override
    public int count() {
        return count;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int find(int p) {
        while (p != a[p]) p = a[p];
        return p;
    }

    @Override
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (a[i] == a[j]) return;
        a[i] = a[j];
        count--;
    }

    public static void main(String[] args) {
        int N = 9;
        int[] a = new int[9];
        for (int i = 0; i < 9; i++) {
            a[i] = i;
        }

        QuickUnionUF quickUnionUF = new QuickUnionUF(a);
        quickUnionUF.union(1, 5);
        quickUnionUF.union(2, 6);
        quickUnionUF.union(6, 7);
        quickUnionUF.union(4, 8);
        quickUnionUF.union(7, 8);


        StdOut.println(quickUnionUF.count());
        StdOut.println(quickUnionUF.find(0));
        StdOut.println(quickUnionUF.find(4));
        StdOut.println(quickUnionUF.find(6));
        StdOut.println(quickUnionUF.find(3));
        StdOut.println(quickUnionUF.connected(2, 4));
        StdOut.println(quickUnionUF.connected(1, 2));
    }
}
