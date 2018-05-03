package test3;

import javax.swing.JApplet;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class TreeInJava extends JApplet {
	// 使用java中的树结构
	private JTree sample;

	// 定义一些常量字符串

	@Override
	public void init() {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode root;
		DefaultMutableTreeNode child;

		final String root_q = "你是一个动物吗?";
		final String left_q = "你比猫大吗？";
		final String right_q = "你生活在水里吗？";
		final String animal1 = "袋鼠";
		final String animal2 = "老鼠";
		final String animal3 = "鲫鱼";
		final String animal4 = "知更鸟";

		root = new DefaultMutableTreeNode(root_q);
		// 创建并插入左子树
		child = new DefaultMutableTreeNode(left_q);
		child.insert(new DefaultMutableTreeNode(animal1), 0);
		child.insert(new DefaultMutableTreeNode(animal2), 1);
		root.insert(child, 0);
		// 创建并插入右子树
		child = new DefaultMutableTreeNode(right_q);
		child.insert(new DefaultMutableTreeNode(animal3), 0);
		child.insert(new DefaultMutableTreeNode(animal4), 1);
		root.insert(child, 1);
		sample = new JTree(root);
		sample.setShowsRootHandles(true);
		getContentPane().add(sample);
	}

}
