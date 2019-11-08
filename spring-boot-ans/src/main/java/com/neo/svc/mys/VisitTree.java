package com.neo.svc.mys;

import java.util.Stack;

/**
 * @author xianshuangzhang
 * @date 2019/9/19 23:29
 */
public class VisitTree {
    public static class TreeNode {
        int val;

        @Override
        public String toString() {
            return "val=" + val;
        }

        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.val = value;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(11);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(13);

        visit(root);

    }

    public static void visit(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {

            while ((root = root.left) != null) {
                stack.push(root);
            }

            TreeNode tnn = stack.pop();
        }
    }
}
