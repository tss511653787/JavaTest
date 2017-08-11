package test3;

import java.util.ArrayDeque;
import java.util.Queue;

/*
 * 图ADT
 * */
public class Graph {
	final static int defalutvalue = 10;
	private int size = defalutvalue;
	public boolean[][] edges = new boolean[getSize()][getSize()];
	boolean[] marked = new boolean[getSize()];
	GraphNode[] nodes = new GraphNode[getSize()];

	public Graph() {
		markInital();
	}

	private void markInital() {
		// TODO Auto-generated method stub
		for (int i = 0; i < getSize(); i++) {
			marked[i] = true;
		}
	}

	public Graph(int size) {
		super();
		this.size = size;
		markInital();
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	/*
	 * 图的深度优先遍历
	 */
	public static void deepFirstGrap(Graph g, int start, boolean[] marked,
			GraphNode[] nodes) {
		if (marked[start]) {
			int[] neighbor = getNeighbor(g, start);
			marked[start] = false;
			System.out.println(nodes[start].getValue());
			for (int i : neighbor) {
				deepFirstGrap(g, i, marked, nodes);
			}
		}
	}

	/*
	 * 图的广度优先遍历(非递归实现)
	 */
	public static void breadFirstGrap(Graph g, int start, boolean[] marked,
			GraphNode[] nodes) {
		if (marked[start]) {
			Queue<Integer> queue = new ArrayDeque<>();
			queue.offer(start);
			while (!queue.isEmpty()) {
				int n = queue.poll();
				if (marked[n]) {
					marked[n] = false;
					System.out.println(nodes[n].getValue());
					int[] nei = getNeighbor(g, n);
					for (int i : nei) {
						queue.offer(i);
					}
				}
			}
		}
	}

	/*
	 * 获取当前节点的出度集合
	 */
	public static int[] getNeighbor(Graph g, int now) {
		// TODO Auto-generated method stub
		int size = g.getSize();
		boolean[][] matrix = g.edges;
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (matrix[now][i]) {
				count++;
			}
		}
		int[] res = new int[count];
		int j = 0;
		for (int i = 0; i < size; i++) {
			if (matrix[now][i]) {
				res[j++] = i;
			}
		}
		return res;
	}
}

class GraphNode {
	String value;

	public GraphNode(String value) {
		super();
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
