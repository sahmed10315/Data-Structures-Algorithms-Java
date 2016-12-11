package binarysearchtree;

import java.util.Arrays;

public class BinarySearchTree {

	/* Class containing left and right child of current node and key value */
	class Node {
		int key;
		Node left, right;

		public Node(int item) {
			key = item;
			left = right = null;
		}
	}

	// Root of BST
	Node root;

	// Constructor
	BinarySearchTree() {
		root = null;
	}

	// A utility function to search a given key in BST
	public Node search(Node root, int key) {
		// Base Cases: root is null or key is present at root
		if (root == null || root.key == key)
			return root;

		// val is greater than root's key
		if (root.key > key)
			return search(root.left, key);
		else {
			// val is less than root's key
			return search(root.right, key);
		}

	}

	void insert(int key) {
		root = insertRec(root, key);
	}

	/* A recursive function to insert a new key in BST */
	Node insertRec(Node root, int key) {

		/* If the tree is empty, return a new node */
		if (root == null) {
			root = new Node(key);
			return root;
		}

		/* Otherwise, recur down the tree */
		if (key < root.key)
			root.left = insertRec(root.left, key);
		else if (key > root.key)
			root.right = insertRec(root.right, key);

		/* return the (unchanged) node pointer */
		return root;
	}

	// This method mainly calls deleteRec()
	void deleteKey(int key) {
		root = deleteRec(root, key);
	}

	/* A recursive function to insert a new key in BST */
	Node deleteRec(Node root, int key) {
		/* Base Case: If the tree is empty */
		if (root == null)
			return root;

		/* Otherwise, recur down the tree */
		if (key < root.key)
			root.left = deleteRec(root.left, key);
		else if (key > root.key)
			root.right = deleteRec(root.right, key);

		// if key is same as root's key, then This is the node
		// to be deleted
		else {
			// node with only one child or no child
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			// node with two children: Get the inorder successor (smallest
			// in the right subtree)
			root.key = minValue(root.right);

			// Delete the inorder successor
			root.right = deleteRec(root.right, root.key);
		}

		return root;
	}

	int minValue(Node node) {
		Node current = node;

		/* loop down to find the leftmost leaf */
		while (current.left != null) {
			current = current.left;
		}
		return (current.key);
	}

	int maxValue(Node root) {
		int maxv = root.key;
		while (root.right != null) {
			maxv = root.right.key;
			root = root.right;
		}
		return maxv;
	}


	/*
	 * Returns true if given search tree is binary search tree (efficient
	 * version)
	 */
	Node prev = null;

	boolean isBSTInorder(Node node) {
		// traverse the tree in inorder fashion and
		// keep a track of previous node
		if (node != null) {
			if (!isBSTInorder(node.left))
				return false;

			// allows only distinct values node
			if (prev != null && node.key <= prev.key)
				return false;
			prev = node;
			return isBSTInorder(node.right);
		}
		return true;
	}

	void printSortedTree(int arr[], int start, int end) {
		if (start > end)
			return;

		// print left subtree
		printSortedTree(arr, start * 2 + 1, end);

		// print root
		System.out.println(arr[start]);

		// print right subtree
		printSortedTree(arr, start * 2 + 2, end);
	}


	// Driver Program to test above functions
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();

		/*
		 * Let us create following BST 50 / \ 30 70 / \ / \ 20 40 60 80
		 */
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);
	}

}
