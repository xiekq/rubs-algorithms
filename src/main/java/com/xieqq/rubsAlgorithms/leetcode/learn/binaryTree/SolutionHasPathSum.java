package com.xieqq.rubsAlgorithms.leetcode.learn.binaryTree;

public class SolutionHasPathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSum(root, sum, 0);
    }

    private boolean hasPathSum(TreeNode node, int sum, int preSum) {

        if(node == null){
            return false;
        }

        preSum += node.val;
        if (null == node.left && null == node.right) {
            return sum == preSum;
        }

        return hasPathSum(node.left, sum, preSum) || hasPathSum(node.right, sum, preSum);
    }

}

