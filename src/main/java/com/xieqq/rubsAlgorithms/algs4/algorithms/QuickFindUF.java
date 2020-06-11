package com.xieqq.rubsAlgorithms.algs4.algorithms;

import com.xieqq.rubsAlgorithms.algs4.StdOut;

public class QuickFindUF implements QuickUF {
    private int id[];
    private int count;

    public QuickFindUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        count = id.length;
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public void union(int p, int q) {

        int pID = find(p);
        int qID = find(q);
        if (pID == qID) return;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
        count--;

    }

    public static void main(String[] args) {
        int N = 9;
        int[] a = new int[9];
        for (int i = 0; i < 9; i++) {
            a[i] = i;
        }

        QuickFindUF quickFindUF = new QuickFindUF(9);
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
