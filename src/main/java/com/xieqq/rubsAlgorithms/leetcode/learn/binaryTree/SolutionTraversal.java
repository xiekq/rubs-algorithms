package com.xieqq.rubsAlgorithms.leetcode.learn.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树前中后序遍历
 */
public class SolutionTraversal {
    List<Integer> orderList = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (null != root) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            orderList.add(root.val);
        }
        return orderList;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (null != root) {
            inorderTraversal(root.left);
            orderList.add(root.val);
            inorderTraversal(root.right);
        }
        return orderList;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (null != root) {
            orderList.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return orderList;
    }

}
