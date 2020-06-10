package com.xieqq.rubsAlgorithms.algs4.algorithms;

/**
 * 快速联通
 */
public interface QuickUF {

    /**
     * 获取
     *
     * @return
     */
    int count();

    /**
     * 判断两个点是否联通
     *
     * @param p
     * @param q
     * @return
     */
    boolean connected(int p, int q);

    /**
     * 查找给定P的根节点
     *
     * @param p
     * @return
     */
    int find(int p);

    /**
     * 连接两个节点
     * @param p
     * @param q
     */
    void union(int p, int q);

}
