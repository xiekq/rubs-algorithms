package com.xieqq.rubsAlgorithms.algs4.algorithms;

public class Shell extends AbstractSort {

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = 3 * h + 1; // 1,4,13,40,121,364,1093,...
        while (h >= 1) { //将数组变为h有序
            for (int i = h; i < N; i++) {
                //将a[i]插入到a[i-h],a[i-2*h],a[i-3*h]...之中
                for (int j = i; j >= h && less(a[j], a[j - 1]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

}
