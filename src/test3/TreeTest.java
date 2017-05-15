package test3;

public class TreeTest {
	public static void main(String[] args) throws CloneNotSupportedException {
		BTNode root = new BTNode(5, null, null);
		root.setLeft(new BTNode(3, null, null));
		root.setRight(new BTNode(8, null, null));
		root.getLeft().setLeft(new BTNode(1, null, null));
		root.getLeft().setRight(new BTNode(4, null, null));
		root.getRight().setLeft(new BTNode(7, null, null));
		root.getRight().setRight(new BTNode(9, null, null));

		// root.preorderprint();
		BTNode.lastorderNoDiGui(root);
	}

}
