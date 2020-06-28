package com.xieqq.rubsAlgorithms.leetcode.learn.binaryTree;

public class SolutionConnect {

    public Node connect(Node root) {
        if (null == root) {
            return null;
        }
        if (null != root.left) {
            root.left.next = root.right;
            connect(root.left);
        }

        if (null != root.right) {
            if (null != root.next) {
                root.right.next = root.next.left;
            }
            connect(root.right);
        }
        return root;
    }

}
