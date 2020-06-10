package com.xieqq.rubsAlgorithms.algs4.algorithms;

import com.xieqq.rubsAlgorithms.algs4.StdOut;

public class QuickFindUF implements QuickUF {

    private int[] a;
    private int count;

    public QuickFindUF(int[] a) {
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

        QuickFindUF quickFindUF = new QuickFindUF(a);
        quickFindUF.union(1, 5);
        quickFindUF.union(2, 6);
        quickFindUF.union(6, 7);
        quickFindUF.union(4, 8);
        quickFindUF.union(7, 8);


        StdOut.println(quickFindUF.count());
        StdOut.println(quickFindUF.find(0));
        StdOut.println(quickFindUF.find(4));
        StdOut.println(quickFindUF.find(6));
        StdOut.println(quickFindUF.find(3));
        StdOut.println(quickFindUF.connected(2, 4));
        StdOut.println(quickFindUF.connected(1, 2));
    }
}
