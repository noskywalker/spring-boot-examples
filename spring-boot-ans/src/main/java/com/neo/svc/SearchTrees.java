package com.neo.svc;

import java.util.Stack;

/**
 * @author xianshuangzhang
 * @date 2019/8/28 18:48
 */
public class SearchTrees {

    public static class Node {
        int val;

        @Override
        public String toString() {
            return "val=" + val;
        }

        Node left;
        Node right;

        public Node(int value) {
            this.val = value;
        }

        public static Node of(int i) {
            Node n = new Node(i);
            return n;
        }
    }

    static int a[] = {500, 400, 550, 350, 450, 520, 560, 330, 360, 420, 470, 510, 530, 540, 580,0,0,0,0,0,0,0,0,0,0,0,0,0,545,0,0};

    public static void main(String[] args) {

        Node node = getTrees();

//        findNode(node, 43);

       Node pp= deleteNode(node, 550);
        System.out.println();



    }

    public static  Node deleteNode(Node head,int value) {

        Node parent = null;
        Node p = head;
        while (p != null && p.val != value) {
            parent = p;

            if (value > p.val) {
                p = p.right;
            } else if (value < p.val) {
                p = p.left;
            } else {
                break;
            }
        }

        //如果左右子节点都为空，则直接父指针值为空即可
        if (p.left == null && p.right == null) {
            if (parent.left.val == p.val) {
                parent.left = null;
            } else if (parent.right.val == p.val) {
                parent.right = null;
            }
        }
        //如果左右都不为空，则将最小的左子节点
        if (p.left != null && p.right != null) {
            Node minNode = findMin(p);
            parent.right = minNode;
            minNode.left = p.left;
        }

        return head;
    }

    public static Node findMin(Node node){
        Node pp=node;
        Node p=node.right;
        while(p.left!=null){
            pp=p;
            p=p.left;
        }

        if(p.right!=null){
            pp.left=p.right;
        }else{
            pp.left=null;
        }

        p.right=pp;

        return p;
    }

    public static Node findNode(Node n, int value) {
        Node p = null;
        p = n;
        while (p!=null) {
            if(value>p.val){
                if(p.right==null){
                    p.right=Node.of(value);
                    break;
                }
                p=p.right;
            }else if(value<p.val){
                if(p.left==null){
                    p.left=Node.of(value);
                    break;
                }
                p=p.left;
            }
        }

        return n;
    }

    private static Node getTrees() {
        Stack<Node> stack = new Stack<>();
        Node root = Node.of(500);
        stack.push(root);
        while (!stack.empty()) {
            Node no = stack.pop();
            int index = findIndex(no.val);
            int leftIndex = index * 2 + 1;
            int rightIndex = index * 2 + 2;
            if (rightIndex < a.length) {
                Node right = Node.of(a[rightIndex]);
                if(right.val!=0) {
                    stack.push(right);
                    no.right = right;
                }
            }
            if (leftIndex < a.length) {
                Node left = Node.of(a[leftIndex]);
                if(left.val!=0) {
                    stack.push(left);
                    no.left = left;
                }
            }
        }

        return root;
    }

    public static int findIndex(int value) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
