package adjacenylist;

import java.util.*;

public class Graph {
	private HashMap<Integer, List<Integer>> adj;

	// Constructor to initialize the graph
	Graph() {
		// Initialize the adj HashMap
		adj = new HashMap<Integer, List<Integer>>();
	}

	public void addEdge(int s, int d) {
		List<Integer> list;
		if (adj.containsKey(s)) {
			list = adj.get(s);
			list.add(d);
			adj.put(s, list);
		} else {
			list = new ArrayList<Integer>();
			list.add(d);
			adj.put(s, list);
		}
	}

	public void printGraph() {
		for (Integer key : adj.keySet()) {
			System.out.print(key + ": ");
			for (Integer value : adj.get(key)) {
				System.out.print(value + " ");
			}
			System.out.println();
		}
	}

	public static void main(String args[]) {
		Graph graph = new Graph();
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 0);
		graph.addEdge(0, 4);
		graph.addEdge(4, 0);
		graph.printGraph();
	}
}