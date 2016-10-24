package minimumspanningtree;

//mst.java
//demonstrates minimum spanning tree 
class StackX {
	private final int SIZE = 20;
	private int[] st;
	private int top;

	public StackX() // constructor
	{
		st = new int[SIZE]; // make array
		top = -1;
	}

	public void push(int j) // put item on stack
	{
		st[++top] = j;
	}

	public int pop() // take item off stack
	{
		return st[top--];
	}

	public int peek() // peek at top of stack
	{
		return st[top];
	}

	public boolean isEmpty() // true if nothing on stack
	{
		return (top == -1);
	}
}

class Vertex {
	public char label; // label (e.g. 'A')
	public boolean wasVisited;

	public Vertex(char lab) // constructor
	{
		label = lab;
		wasVisited = false;
	}
}

class Graph {
	private final int MAX_VERTS = 20;
	private Vertex vertexList[]; // list of vertices
	private int adjMat[][]; // adjacency matrix
	private int nVerts; // current number of vertices
	private StackX theStack;

	public Graph() // constructor
	{
		vertexList = new Vertex[MAX_VERTS];
		// adjacency matrix
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for (int j = 0; j < MAX_VERTS; j++) // set adjacency
			for (int k = 0; k < MAX_VERTS; k++) // matrix to 0
				adjMat[j][k] = 0;
		theStack = new StackX();
	}

	public void addVertex(char lab) {
		vertexList[nVerts++] = new Vertex(lab);
	}

	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}

	public void displayVertex(int v) {
		System.out.print(vertexList[v].label);
	}

	public void mst() // minimum spanning tree (depth first)
	{ // start at 0
		vertexList[0].wasVisited = true; // mark it
		theStack.push(0); // push it

		while (!theStack.isEmpty()) // until stack empty
		{ // get stack top
			int currentVertex = theStack.peek();
			// get next unvisited neighbor
			int v = getAdjUnvisitedVertex(currentVertex);
			if (v == -1) // if no more neighbors
				theStack.pop(); // pop it away
			else // got a neighbor
			{
				vertexList[v].wasVisited = true; // mark it
				theStack.push(v); // push it
				// display edge
				displayVertex(currentVertex); // from currentV
				displayVertex(v); // to v
				System.out.print(" ");
			}
		}

		// stack is empty, so we're done
		for (int j = 0; j < nVerts; j++) // reset flags
			vertexList[j].wasVisited = false;
	}

	public int getAdjUnvisitedVertex(int v) {
		for (int j = 0; j < nVerts; j++)
			if (adjMat[v][j] == 1 && vertexList[j].wasVisited == false)
				return j;
		return -1;
	}
}

public class MST {
	public static void main(String[] args) {
		Graph theGraph = new Graph();
		theGraph.addVertex('A'); // 0 (start for mst)
		theGraph.addVertex('B'); // 1
		theGraph.addVertex('C'); // 2
		theGraph.addVertex('D'); // 3
		theGraph.addVertex('E'); // 4

		theGraph.addEdge(0, 1); // AB
		theGraph.addEdge(0, 2); // AC
		theGraph.addEdge(0, 3); // AD
		theGraph.addEdge(0, 4); // AE
		theGraph.addEdge(1, 2); // BC
		theGraph.addEdge(1, 3); // BD
		theGraph.addEdge(1, 4); // BE
		theGraph.addEdge(2, 3); // CD
		theGraph.addEdge(2, 4); // CE
		theGraph.addEdge(3, 4); // DE

		System.out.print("Minimum spanning tree: ");
		theGraph.mst(); // minimum spanning tree
		System.out.println();
	}
}
