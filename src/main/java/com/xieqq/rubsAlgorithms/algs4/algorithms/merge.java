package com.xieqq.rubsAlgorithms.algs4.algorithms;

public class merge extends AbstractSort {

    private Comparable[] tmp;

    @Override
    public void sort(Comparable[] a) {
        tmp = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    /**
     * 对给定数组的下标 lo到hi之间的元素进行排序
     *
     * @param a
     * @param lo
     * @param hi
     */
    private void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2; //以中间下标为分割
        sort(a, lo, mid); //对左侧数组进行排序
        sort(a, mid + 1, hi);//对右侧数组进行排序
        merge(a, lo, mid, hi);//将排好序的左右两个数组归并
    }

    private void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;

        //临时数组lo至hi之间的元素赋值
        for (int k = lo; k <= hi; k++) {
            tmp[k] = a[k];
        }

        //归并回a数组
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = a[j++];
            else if (j > hi) a[k] = a[i++];
            else if (less(tmp[j], tmp[i])) a[k] = tmp[j++];
            else a[k] = tmp[i++];
        }
    }

}
