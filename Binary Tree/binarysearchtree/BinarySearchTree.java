package binarysearchtree;

import java.util.Arrays;

import binarytree.Node;

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

		// val is less than root's key
		return search(root.right, key);
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
	 * returns true if given search tree is binary search tree (efficient
	 * version)
	 */
	boolean isBST() {
		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	/*
	 * Returns true if the given tree is a BST and its values are >= min and <=
	 * max.
	 */
	boolean isBSTUtil(Node node, int min, int max) {
		/* an empty tree is BST */
		if (node == null)
			return true;

		/* false if this node violates the min/max constraints */
		if (node.key < min || node.key > max)
			return false;

		/*
		 * otherwise check the subtrees recursively tightening the min/max
		 * constraints
		 */
		// Allow only distinct values
		return (isBSTUtil(node.left, min, node.key - 1) && isBSTUtil(node.right, node.key + 1, max));
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

	Node inOrderSuccessorContainingParent(Node root, Node n) {

		if (n.right != null) {
			return minValue1(n.right);
		}

		Node p = n.parent;
		while (p != null && n == p.right) {
			n = p;
			p = p.parent;
		}
		return p;
	}

	Node inOrderSuccessor(Node root, Node n) {
		// step 1 of the above algorithm
		if (n.right != null)
			return minValue1(n.right);

		Node succ = null;

		// Start from root and search for successor down the tree
		while (root != null) {
			if (n.key < root.key) {
				succ = root;
				root = root.left;
			} else if (n.key > root.key)
				root = root.right;
			else
				break;
		}

		return succ;
	}

	Node minValue1(Node node) {
		Node current = node;

		/* loop down to find the leftmost leaf */
		while (current.left != null) {
			current = current.left;
		}
		return current;
	}

	/*
	 * The functions prints all the keys which in the given range [k1..k2]. The
	 * function assumes than k1 < k2
	 */
	void printKeysInGvnRange(Node node, int k1, int k2) {

		/* base case */
		if (node == null) {
			return;
		}

		/*
		 * Since the desired o/p is sorted, recurse for left subtree first If
		 * root->data is greater than k1, then only we can get o/p keys in left
		 * subtree
		 */
		if (k1 < node.key) {
			printKeysInGvnRange(node.left, k1, k2);
		}

		/* if root's data lies in range, then prints root's data */
		if (k1 <= node.key && k2 >= node.key) {
			System.out.print(node.key + " ");
		}

		/*
		 * If root->data is smaller than k2, then only we can get o/p keys in
		 * right subtree
		 */
		if (k2 > node.key) {
			printKeysInGvnRange(node.right, k1, k2);
		}
	}

	/*
	 * A function that constructs Balanced Binary Search Tree from a sorted
	 * array
	 */
	Node sortedArrayToBST(int arr[], int start, int end) {

		/* Base Case */
		if (start > end) {
			return null;
		}

		/* Get the middle element and make it root */
		int mid = (start + end) / 2;
		Node node = new Node(arr[mid]);

		/*
		 * Recursively construct the left subtree and make it left child of root
		 */
		node.left = sortedArrayToBST(arr, start, mid - 1);

		/*
		 * Recursively construct the right subtree and make it right child of
		 * root
		 */
		node.right = sortedArrayToBST(arr, mid + 1, end);

		return node;
	}

	// This function converts a given Binary Tree to BST
	void binaryTreeToBST(Node root) {
		// base case: tree is empty
		if (root == null)
			return;

		/*
		 * Count the number of nodes in Binary Tree so that we know the size of
		 * temporary array to be created
		 */
		int n = size(root);

		// Create a temp array arr[] and store inorder traversal of tree in
		// arr[]
		int[] arr = new int[n];
		int i = 0;
		storeInorder(root, arr, i);

		Arrays.sort(arr);

		// Copy array elements back to Binary Tree
		i = 0;
		arrayToBST(arr, root, i);
	}

	/* Computes number of nodes in tree */
	int size(Node node) {
		if (node == null)
			return 0;
		else
			return (size(node.left) + 1 + size(node.right));
	}

	/*
	 * A helper function that stores inorder traversal of a tree rooted with
	 * node
	 */
	void storeInorder(Node node, int inorder[], int index) {
		// Base Case
		if (node == null)
			return;

		/* first store the left subtree */
		storeInorder(node.left, inorder, index);

		/* Copy the root's data */
		inorder[index++] = node.key;

		/* finally store the right subtree */
		storeInorder(node.right, inorder, index);
	}

	/*
	 * A helper function that copies contents of arr[] to Binary Tree. This
	 * functon basically does Inorder traversal of Binary Tree and one by one
	 * copy arr[] elements to Binary Tree nodes
	 */
	void arrayToBST(int[] arr, Node root, int index) {
		// Base Case
		if (root == null)
			return;

		/* first update the left subtree */
		arrayToBST(arr, root.left, index);

		/* Now update root's data and increment index */
		root.key = arr[index++];

		/* finally update the right subtree */
		arrayToBST(arr, root.right, index);
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
