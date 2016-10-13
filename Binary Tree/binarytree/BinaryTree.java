package binarytree;

import java.util.LinkedList;
import java.util.Queue;

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
	 * postorder traversal, also used to delete the tree.
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

	/* Returns true/false if tree a, and tree b are identical */
	boolean identicalTrees(Node a, Node b) {
		/* 1. both empty */
		if (a == null && b == null)
			return true;

		/* 2. both non-empty -> compare them */
		if (a != null && b != null)
			return (a.key == b.key && identicalTrees(a.left, b.left) && identicalTrees(a.right, b.right));

		/* 3. one empty, one not -> false */
		return false;
	}

	/* Iterative implementation using a stack for in order traversal */
	void iterativeInorder() {
		if (root == null) {
			return;
		}

		// keep the nodes in the path that are waiting to be visited
		Stack<Node> stack = new Stack<Node>(20);
		Node node = root;

		// first node to be visited will be the left one
		while (node != null) {
			stack.push(node);
			node = node.left;
		}

		// traverse the tree
		while (stack.size() > 0) {
			// visit the top node
			node = stack.pop();
			System.out.print(node.key + " ");
			if (node.right != null) {
				node = node.right;

				// the next node to be visited is the leftmost
				while (node != null) {
					stack.push(node);
					node = node.left;
				}
			}
		}
	}

	void iterativePreorder() {
		iterativePreorder(root);
	}

	/* An iterative process to print preorder traversal of Binary tree */
	void iterativePreorder(Node node) {

		// Base Case
		if (node == null) {
			return;
		}

		// Create an empty stack and push root to it
		Stack<Node> nodeStack = new Stack<Node>(20);
		nodeStack.push(root);

		/*
		 * Pop all items one by one. Do following for every popped item a) print
		 * it b) push its right child c) push its left child Note that right
		 * child is pushed first so that left is processed first
		 */
		while (nodeStack.isEmpty() == false) {

			// Pop the top item from stack and print it
			Node mynode = nodeStack.peek();
			System.out.print(mynode.key + " ");
			nodeStack.pop();

			// Push right and left children of the popped node to stack
			if (mynode.right != null) {
				nodeStack.push(mynode.right);
			}
			if (mynode.left != null) {
				nodeStack.push(mynode.left);
			}
		}
	}

	/* Iterative Post order traversal using two stacks */
	public void iterativePostOrder(Node root) {
		if (root == null)
			return;

		Stack<Node> stack1 = new Stack<Node>(7);
		Stack<Node> stack2 = new Stack<Node>(7);
		Node node = null;

		stack1.push(root);

		while (!stack1.isEmpty()) {
			node = stack1.pop();
			stack2.push(node);

			if (node.left != null)
				stack1.push(node.left);
			if (node.right != null)
				stack1.push(node.right);
		}

		while (!stack2.isEmpty()) {
			node = stack2.pop();
			System.out.print(node.key + " ");
		}
	}

	/* Level order traversal done iteratively through queue */
	void iterativeLevelOrder() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {

			/* poll() removes the present head. */
			Node tempNode = queue.poll();
			System.out.print(tempNode.key + " ");

			/* Enqueue left child */
			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}

			/* Enqueue right child */
			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}
	}

	/* Method to print level order traversal of tree */
	void printLevelOrder() {
		int h = height(root);
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

	/* Function to get the maximum width of a binary tree */
	int getMaxWidth(Node node) {
		int maxWidth = 0;
		int width;
		int h = height(node);
		int i;

		/*
		 * Get width of each level and compare the width with maximum width so
		 * far
		 */
		for (i = 1; i <= h; i++) {
			width = getWidth(node, i);
			if (width > maxWidth)
				maxWidth = width;
		}

		return maxWidth;
	}

	/* Get width of a given level */
	int getWidth(Node node, int level) {
		if (node == null)
			return 0;

		if (level == 1)
			return 1;
		else if (level > 1)
			return getWidth(node.left, level - 1) + getWidth(node.right, level - 1);
		return 0;
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
			res = lres;
		if (rres > res)
			res = rres;
		return res;
	}

	/*
	 * Compute the "height" of a tree -- the number of nodes along the longest
	 * path from the root node down to the farthest leaf node.
	 */
	int height(Node root) {
		if (root == null)
			return 0;
		else {
			/* compute height of each subtree */
			int lheight = height(root.left);
			int rheight = height(root.right);

			/* use the larger one */
			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}
	}

	/* Much simpler version of finding height of a binary tree */
	public int heightOtherVersion(Node root) {
		if (root == null) {
			return -1;
		}
		return Math.max(heightOtherVersion(root.left), heightOtherVersion(root.right)) + 1;
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

	/* Returns true if binary tree with root as root is height-balanced */
	boolean isBalanced(Node node) {
		int lh; /* for height of left subtree */

		int rh; /* for height of right subtree */

		/* If tree is empty then return true */
		if (node == null)
			return true;

		/* Get the height of left and right sub trees */
		lh = height(node.left);
		rh = height(node.right);

		if (Math.abs(lh - rh) > 1)
			return false;

		return isBalanced(node.left) && isBalanced(node.right);
	}

	/*
	 * Helper function for getLevel(). It returns level of the data if data is
	 * present in tree, otherwise returns 0.
	 */
	int getLevelUtil(Node node, int data, int level) {
		if (node == null)
			return 0;

		if (node.key == data)
			return level;

		int downlevel = getLevelUtil(node.left, data, level + 1);
		if (downlevel != 0)
			return downlevel;

		downlevel = getLevelUtil(node.right, data, level + 1);
		return downlevel;
	}

	/* Returns level of given data value */
	int getLevel(Node node, int data) {
		return getLevelUtil(node, data, 1);
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
