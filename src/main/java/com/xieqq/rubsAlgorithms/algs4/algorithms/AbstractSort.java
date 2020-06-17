package com.xieqq.rubsAlgorithms.algs4.algorithms;

import com.xieqq.rubsAlgorithms.algs4.StdOut;

/**
 * 比较交换排序算法抽象类
 */
public abstract class AbstractSort {

    /**
     * 对给定数组按从小到大排序
     *
     * @param a
     */
    public abstract void sort(Comparable[] a);

    /**
     * 判斷數字是否已經有序
     *
     * @param a
     * @return
     */
    public boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }

    /**
     * 比较两个元素，第一个参数是否小于第二个参数
     *
     * @param v
     * @param w
     * @return
     */
    protected boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 交换数组中的两个元素
     *
     * @param a
     * @param i
     * @param j
     */
    protected void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 在一行中打印数组
     *
     * @param a
     */
    protected void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

}
