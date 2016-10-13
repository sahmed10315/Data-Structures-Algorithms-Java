package binarytree;

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
    public void insert(int data)
    {
        root = insert(root, data);
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
