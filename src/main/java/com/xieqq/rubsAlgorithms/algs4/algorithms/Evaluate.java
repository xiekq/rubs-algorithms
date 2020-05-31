package com.xieqq.rubsAlgorithms.algs4.algorithms;

import com.xieqq.rubsAlgorithms.algs4.StdIn;
import com.xieqq.rubsAlgorithms.algs4.StdOut;
import com.xieqq.rubsAlgorithms.util.Stack;

public class Evaluate {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("(")) ;
            else if (s.equals("+")
                    || s.equals("-")
                    || s.equals("*")
                    || s.equals("/")
                    || s.equals("sqrt")
            ) {
                ops.push(s);
            } else if (s.equals(")")) {
                String op = ops.pop();
                Double v = vals.pop();
                if (op.equals("+")) {
                    v = vals.pop() + v;
                } else if (op.equals("-")) {
                    v = vals.pop() - v;
                } else if (op.equals("*")) {
                    v = vals.pop() * v;
                } else if (op.equals("*")) {
                    v = vals.pop() / v;
                } else {
                    v = Math.sqrt(v);
                }
                vals.push(v);
            } else {
                vals.push(Double.valueOf(s));
            }
        }
        StdOut.println("result is : " + vals.pop());
    }
}
