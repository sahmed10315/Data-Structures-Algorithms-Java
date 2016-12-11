package binarytree;

import java.util.LinkedList;
import java.util.Queue;

import Height.Node;
import implementation.arrays.Stack;

/* Class containing left and right child of current
 node and key value*/
class Node {
	int key;
	Node left, right;

	public Node(int item) {
		key = item;
		left = right = null;
	}
}

/* Binary tree class containing fundamental algorithms for binary trees */
public class BinaryTree {
	// Root of Binary Tree
	Node root;

	// Constructors
	BinaryTree(int key) {
		root = new Node(key);
	}

	BinaryTree() {
		root = null;
	}

	/* Function to insert data recursively */
	public Node insert(Node node, int data) {
		if (node == null)
			node = new Node(data);
		else {
			if (node.right == null)
				node.right = insert(node.right, data);
			else
				node.left = insert(node.left, data);
		}
		return node;
	}

	/* Functions to insert data */
	public void insert(int data) {
		root = insert(root, data);
	}

	/*
	 * Given a binary tree, print its nodes according to the "bottom-up"
	 * post-order traversal, also used to delete the tree.
	 */
	void printPostorder(Node node) {
		if (node == null)
			return;

		// first recur on left subtree
		printPostorder(node.left);

		// then recur on right subtree
		printPostorder(node.right);

		// now deal with the node
		System.out.print(node.key + " ");
	}

	/*
	 * Given a binary tree, print its nodes in inorder. Incase of BST gives
	 * nodes in non-decreasing order
	 */
	void printInorder(Node node) {
		if (node == null)
			return;

		/* first recur on left child */
		printInorder(node.left);

		/* then print the data of node */
		System.out.print(node.key + " ");

		/* now recur on right child */
		printInorder(node.right);
	}

	/*
	 * Given a binary tree, print its nodes in preorder Mostly used to create a
	 * copy of the tree
	 */
	void printPreorder(Node node) {
		if (node == null)
			return;

		/* first print data of node */
		System.out.print(node.key + " ");

		/* then recur on left subtree */
		printPreorder(node.left);

		/* now recur on right subtree */
		printPreorder(node.right);
	}

	/* Method to print level order traversal of tree */
	void printLevelOrder() {
		int h = heightOtherVersion(root);
		int i;
		for (i = 1; i <= h; i++)
			printGivenLevel(root, i);
	}

	/* Print nodes at the given level */
	void printGivenLevel(Node root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.key + " ");
		else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}

	/* Computes number of nodes in tree */
	int size(Node node) {
		if (node == null)
			return 0;
		else
			return (size(node.left) + 1 + size(node.right));
	}

	/* Get the count of leaf nodes in the tree */
	int getLeafCount(Node node) {
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return 1;
		else
			return getLeafCount(node.left) + getLeafCount(node.right);
	}

	/* Much simpler version of finding height of a binary tree */
	public int heightOtherVersion(Node root) {
		if (root == null) {
			return -1;
		}
		return Math.max(heightOtherVersion(root.left), heightOtherVersion(root.right)) + 1;
	}

	/* Returns maximum value in a given Binary Tree */
	int findMax(Node root) {
		// Base case
		if (root == null)
			return Integer.MIN_VALUE;

		// Return maximum of 3 values:
		// 1) Root's data 2) Max in Left Subtree
		// 3) Max in right subtree
		int res = root.key;
		int lres = findMax(root.left);
		int rres = findMax(root.right);
		if (lres > res)
			return lres;
		if (rres > res)
			return rres;
		return res;
	}

	/* Delete tree using post order traversal */
	void deleteTree(Node node) {
		if (node == null)
			return;

		/* first delete both subtrees */
		deleteTree(node.left);
		deleteTree(node.right);

		/* then delete the node */
		System.out.println("The deleted node is " + node.key);
		node = null;
	}

	/* Recursively search a binary tree */
	public boolean searchRecursive1(int data, Node node) {
		boolean result = false;
		if (node == null)
			return false;
		if (node.key == data)
			return true;
		if (node.left != null)
			result = searchRecursive1(data, node.left);
		if (result == false)
			result = searchRecursive1(data, node.right);
		return result;
	}

	/* Much elegant way to write a recursive search for a binary tree */
	public boolean searchRecursive2(int num, Node root) {
		return root != null
				&& (root.key == num || searchRecursive2(num, root.left) || searchRecursive2(num, root.right));
	}

	/* An iterative process to search an element x in a given binary tree */
	boolean iterativeSearch(Node root, int x) {
		// Base Case
		if (root == null)
			return false;

		// Create an empty queue for level order traversal
		Queue<Node> q = new LinkedList<Node>();

		// Enqueue Root and initialize height
		q.add(root);

		// Queue based level order traversal
		while (q.isEmpty() == false) {
			// See if current node is same as x
			Node n = q.peek();
			if (n.key == x)
				return true;

			// Remove current node and enqueue its children
			q.poll();
			if (n.left != null)
				q.add(n.left);
			if (n.right != null)
				q.add(n.right);
		}

		return false;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.insert(5);
		bt.insert(6);
		bt.insert(7);
		bt.insert(8);
		bt.insert(9);
		bt.insert(1);
		bt.insert(2);
		bt.insert(3);
		bt.insert(4);
	}
}