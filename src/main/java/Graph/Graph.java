package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import test3.BTNode;

//图的ADT实现

public class Graph {
	// 使用临街矩阵存贮图的边
	// 使用obj数组存贮图定点的标签值
	private boolean[][] edges;
	private Object[] labels;
	private int size;// 顶点的个数

	public boolean[][] getEdges() {
		return edges;
	}

	public void setEdges(boolean[][] edges) {
		this.edges = edges;
	}

	public Object getLabels(int vex) {
		return labels[vex];
	}

	public void setLabels(int vex, Object obj) {
		labels[vex] = obj;
	}

	public Graph(int size) {
		this.size = size;
		edges = new boolean[size][size];
		labels = new Object[size];
	}

	public void addEdge(int from, int to) {
		edges[from][to] = true;
	}

	public void removeEdge(int from, int to) {
		edges[from][to] = false;
	}

	public boolean isEdge(int from, int to) {
		return edges[from][to];
	}

	// 统计第一顶点的出度
	public int[] neighbor(int vex) {
		int count = 0;
		// 判断这个点后几个出度
		for (int i = 0; i < size; i++) {
			if (edges[vex][i] == true)
				count++;
		}
		// 将这些出度放到一个数组中
		int[] answer = new int[count];
		count = 0;
		for (int j = 0; j < size; j++) {
			if (edges[vex][j] == true) {
				answer[count++] = j;
			}
		}
		return answer;
	}

	// 图的深度优先遍历
	public static void deepFirstPrint(Graph g, int vex) {
		// boolen数组的初始值都为false
		boolean[] marked = new boolean[g.size];
		dedpFirstRecurse(g, vex, marked);

	}

	public static void dedpFirstRecurse(Graph g, int vex, boolean[] marked) {
		int[] connect = g.neighbor(vex);
		int i;
		int nextNeigh;
		// 已经访问
		marked[vex] = true;
		System.out.print(g.getLabels(vex) + " ");
		for (i = 0; i < connect.length; i++) {
			nextNeigh = connect[i];
			if (!marked[nextNeigh]) {
				dedpFirstRecurse(g, nextNeigh, marked);
			}
		}
	}

	// 图深度优先遍历的栈实现
	public static void DFSfirstRecurse(Graph g, int vex, boolean[] marked) {
		// vex 是图定点的编号 从第vex个定点开始遍历
		Stack<Integer> stk = new Stack<>();
		stk.push(vex);
		while (!stk.isEmpty()) {
			int tail = stk.pop();
			System.out.println(g.getLabels(tail));
			marked[tail] = true;
			int[] connect = g.neighbor(tail);
			for (int i : connect) {
				if (!marked[i]) {
					stk.push(i);
				}
			}
		}
	}

	// 广度优先遍历
	public static void BreadthFirst(Graph g, int vex) {
		boolean[] marked = new boolean[g.size];
		BreadthFirstsearch(g, vex, marked);

	}

	// 图的广度优先遍历
	// while
	private static void BreadthFirstsearch(Graph g, int vex, boolean[] marked) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList<Integer>();
		if (marked[vex]) {
			System.out.println("Already find!");
		} else {
			queue.offer(vex);
			while (!queue.isEmpty()) {
				int v = queue.poll();
				marked[v] = true;
				System.out.println(g.getLabels(v));
				int[] connct = g.neighbor(v);
				for (int i = 0; i < connct.length; i++) {
					int next = connct[i];
					if (!marked[next]) {
						queue.offer(next);
					}
				}
			}
		}
	}

}
