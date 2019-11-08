package com.neo.svc;

import java.util.*;

public class Trees {

	public static class TreeNode {
		int val;

		@Override
		public String toString() {
			return "" + val;
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

	public static int getHeight(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int height = 0;
		while (!queue.isEmpty()) {
			int length = queue.size();
			height++;
			for (int i = 0; i < length; i++) {

				TreeNode tn = queue.poll();
				if (tn.left != null) {
					queue.add(tn.left);
				}
				if (tn.right != null) {
					queue.add(tn.right);
				}
			}
		}
		return height;
	}

	public static void postOrderWithoutRecursion(TreeNode root) {
		Stack<TreeNode> nodes = new Stack<>();
		nodes.push(root);

		while (!nodes.isEmpty()) {
			TreeNode current = nodes.peek();

			if (current.isLeaf()) {
				TreeNode node = nodes.pop();
				System.out.printf("%s ", node.val);
			} else {

				if (current.right != null) {
					nodes.push(current.right);
					current.right = null;
				}

				if (current.left != null) {
					nodes.push(current.left);
					current.left = null;
				}
			}

		}
	}

	public static void preOrder(TreeNode node) {
		Stack<TreeNode> trees = new Stack<>();
		trees.push(node);
		while (!trees.isEmpty()) {
			TreeNode tn = trees.peek();
			if (!tn.isLeaf()) {
				TreeNode t1 = trees.pop();
				if (t1.right != null)
					trees.push(t1.right);
				if (t1.left != null)
					trees.push(t1.left);
				System.out.println(t1.val);
			} else {
				System.out.println(trees.pop().val);
			}
		}
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root, temp = null;
		List<Integer> lists = new ArrayList<>();
		if (root == null) return lists;
		// 判断条件：所有栈为空，且节点指向为空，即所有节点已经完成遍历
		while (!stack.isEmpty() || node != null) {
			// 向左搜索，寻找最左的节点，即中序遍历的第一个节点
			while (node != null) {
				stack.add(node);
				node = node.left;
			}
			// 对每一个节点进行判断
			if (!stack.empty()) {
				// 获取当前节点
				temp = stack.pop();
				// 遍历该节点
				lists.add(temp.val);
				// 如果该节点为内部节点，则按中序遍历的顺序，遍历其右子节点
				node = temp.right;
			}
		}
		return lists;
	}






	public static void testMiddle(TreeNode root){
		Stack<TreeNode> stack=new Stack<>();
		TreeNode node=root,temp=null;
		while (!stack.isEmpty()||node!=null){
			while(node!=null){
				stack.push(node);
				node=node.left;
			}
			if(!stack.isEmpty()){
				temp=stack.pop();
				System.out.println(temp.val);
				node=temp.right;
			}
		}
	}


	public static void posOrderUnRecur2(TreeNode previs){
		if(previs != null){
			Stack<TreeNode> stack = new Stack<TreeNode>();
			stack.push(previs);
			TreeNode current = null;
			while(!stack.isEmpty()){
				current = stack.peek();
				if(current.left != null && previs != current.left && previs != current.right){
					stack.push(current.left);
				}else if(current.right != null && previs != current.right){
					stack.push(current.right);
				}else{
					System.out.print(stack.pop().val + " ");
					previs = current;
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node2=new TreeNode(2);
		TreeNode node3=new TreeNode(3);
		TreeNode node4=new TreeNode(4);
		TreeNode node5=new TreeNode(5);
		TreeNode node6=new TreeNode(6);
		TreeNode node7=new TreeNode(7);
		TreeNode node8=new TreeNode(8);
		root.left=node2;
		root.right=node5;

		node2.left=node3;
		node2.right=node4;

		node5.left=node6;
		node5.right=node7;
		node7.left=node8;

		posOrderUnRecur2(root);

		System.out.println(getHeight(root));
	}
}