package com.xieqq.rubsAlgorithms.leetcode.learn.binaryTree;

import com.xieqq.rubsAlgorithms.algs4.StdOut;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionLevelTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> orderList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (null != root) {
            int level = 0;
            int size = 1;
            queue.add(root);
            return levelOrder(orderList, queue, level, size);
        }
        return orderList;
    }

    public List<List<Integer>> levelOrder(List<List<Integer>> orderList, Queue<TreeNode> queue, int level, int preSize) {
        List<Integer> leverList = new ArrayList<>();
        int size = 0;
        while (preSize > 0) {
            TreeNode node = queue.remove();
            leverList.add(node.val);
            if (null != node.left) {
                queue.add(node.left);
                size++;
            }
            if (null != node.right) {
                queue.add(node.right);
                size++;
            }
            preSize--;
        }

        orderList.add(leverList);

        if (size > 0) {
            return levelOrder(orderList, queue, ++level, size);
        }
        return orderList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 1;

        TreeNode level1Left = new TreeNode();
        level1Left.val = 4;
        TreeNode level1Right = new TreeNode();
        level1Right.val = 6;

        root.left = level1Left;
        root.right = level1Right;

        TreeNode level2Left = new TreeNode();
        level2Left.val = 8;

        level1Right.left = level2Left;

        SolutionLevelTraversal levelTraversal = new SolutionLevelTraversal();
        List<List<Integer>> orderList = levelTraversal.levelOrder(root);
        StdOut.println(orderList);

    }

}
