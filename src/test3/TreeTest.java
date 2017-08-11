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
		// 删除树最左面节点
		// root.removeRightMost();
		// root.preorderprint();
		System.out.println();
		// 数的复制 后续遍历 递归复制树
		BTNode copyTree = BTNode.copyTree(root);
		copyTree.preorderprint();
		System.out.println();

		copyTree.AnewPreorderprint();
		// BSTtree test
		TreeBagSou bst = new TreeBagSou();
		bst.setRoot(root);
		bst.getRoot().preorderprint();
		System.out.println();
		// 删除节点
		bst.deleteNodeInBST(8);
		bst.getRoot().preorderprint();
	}

}
