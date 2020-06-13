package com.xieqq.rubsAlgorithms.algs4.algorithms;

import com.xieqq.rubsAlgorithms.algs4.StdOut;

public class WeightedQuickUnionUF implements QuickUF {

    private int[] id;
    private int[] sz;
    private int count;

    public WeightedQuickUnionUF(int N) {
        count = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
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
        while (p != id[p]) p = id[p];
        return p;
    }

    @Override
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (id[i] == id[j]) return;
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }

    public static void main(String[] args) {
        int N = 9;
        WeightedQuickUnionUF quickUnionUF = new WeightedQuickUnionUF(N);
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
