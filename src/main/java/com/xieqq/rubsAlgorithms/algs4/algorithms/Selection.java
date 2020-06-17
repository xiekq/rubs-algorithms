package com.xieqq.rubsAlgorithms.algs4.algorithms;

public class Selection extends AbstractSort {
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i; //最小元素的索引
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) min = j;
                exch(a, i, min);
            }
        }
    }
}
