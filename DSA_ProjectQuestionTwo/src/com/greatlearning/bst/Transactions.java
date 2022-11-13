package com.greatlearning.bst;

public class Transactions {
	
		static class Node{
			int data;
			Node left;
			Node right;
			
			public Node (int data) {
				this.data=data;
				this.left=this.right=null;
			}
		}
		
		static Node headNode = null;
		static Node prevNode = null;
		
		static void convertBSTIntoSkewedTree(Node root) {
			if(root==null) {
				return;
			}
			convertBSTIntoSkewedTree(root.left);
			
			if(headNode == null) {
				headNode = root;
				root.left=null;
				prevNode=root;
			}else {
				prevNode.right=root;
				root.left=null;
				prevNode=root;
			}
			convertBSTIntoSkewedTree(root.right);	
		}
		
		static void traverseRightSkewedTree(Node root) {
			if(root == null) {
				return;
			}
			System.out.print(root.data+" ");
			traverseRightSkewedTree(root.right);
		}
		
		public static void main(String args []) {
			// Initializing the BST
			
			Node tree = new Node(50);
			tree.left = new Node(30);
			tree.right = new Node(60);
			tree.left.left = new Node(10);
			tree.right.left = new Node(55);
			
			// Convert the Binary Search Tree into a Skewed Tree
			convertBSTIntoSkewedTree(tree);
			
			// traverse right skewed Tree
			traverseRightSkewedTree(headNode);
		}
		
}
