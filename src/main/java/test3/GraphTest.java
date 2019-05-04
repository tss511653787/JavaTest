package test3;

/*
 * 图遍历测试类
 * */
public class GraphTest {
	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.edges[0][1] = true;
		g.edges[0][2] = true;
		g.edges[1][3] = true;
		g.edges[2][3] = true;
		GraphNode[] testnodes = new GraphNode[4];
		testnodes[0] = new GraphNode("A");
		testnodes[1] = new GraphNode("B");
		testnodes[2] = new GraphNode("C");
		testnodes[3] = new GraphNode("D");
		Graph.deepFirstGrap(g, 0, g.marked, testnodes);
		//Graph.breadFirstGrap(g, 0, g.marked, testnodes);
	}
}
