package com.xieqq.rubsAlgorithms.util;

import com.xieqq.rubsAlgorithms.algs4.StdIn;
import com.xieqq.rubsAlgorithms.algs4.StdOut;

public class BinarySearchST<Key extends Comparable<Key>, Value> {

    private Node root;

    class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;

    }

    public boolean isEmpty() {
        return null == root;
    }

    public Value get(Key key) {
        Node node = helper(key, root);
        return node == null ? null : node.value;
    }

    private Node helper(Key key, Node node) {
        if (null == node) {
            return null;
        }
        if (node.key.compareTo(key) == 0) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return helper(key, node.left);
        } else {
            return helper(key, node.right);
        }
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (null == node) {
            node = new Node();
            node.key = key;
            node.value = value;
        } else if (key.compareTo(node.key) < 0) {
            node.left = put(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    private int getSize(Node node) {
        if (null != node) {
            return getSize(node.left) + getSize(node.right) + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        BinarySearchST<String, String> binarySearchST = new BinarySearchST();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            String[] a = s.split(":");
            String key = a[0];
            String value = a[1];
            binarySearchST.put(key, value);
        }
        StdOut.println(binarySearchST.get("g"));
    }

}
