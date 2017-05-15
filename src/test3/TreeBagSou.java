package test3;

//使用BTnode数据结构 构建一个二叉搜索树的ADT
//二叉搜索树特点: 左孩子小于等于根  右孩子大于根

public class TreeBagSou implements Cloneable {
	private BTNode root;

	public TreeBagSou() {
		// 构造方法将root设置为空
		this.root = null;
	}

	public BTNode getRoot() {
		return root;
	}

	public void setRoot(BTNode root) {
		this.root = root;
	}

	public TreeBagSou(BTNode root) {
		this.root = root;
	}

	// size方法
	public static int size(BTNode root) {
		return BTNode.Treesize(root);
	}

	// clone

	@Override
	protected TreeBagSou clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		BTNode aNew = BTNode.copyTree(this.root);
		return new TreeBagSou(aNew);
	}

	// target在二叉搜索树中出现的次数
	public static int countOccurrence(TreeBagSou tree, int target) {
		BTNode root = tree.root;
		BTNode cursor = root;
		int answer = 0;
		while (true) {
			if (cursor == null) {
				break;
			} else if ((int) cursor.getData() > target) {
				cursor = cursor.getLeft();
			} else if ((int) cursor.getData() == target) {
				answer++;
				cursor = cursor.getLeft();
			} else {
				cursor = cursor.getRight();
			}
		}
		return answer;
	}

	// add添加一个新的元素到二叉搜素树中
	public void add(int element) {
		BTNode cursor = root;
		if (cursor == null) {
			// 为空的情况
			root = (new BTNode(element, null, null));
		}
		while (true) {
			if ((int) cursor.getData() >= element) {
				BTNode next = cursor.getLeft();
				if (next != null) {
					cursor = next;
				} else {
					cursor.setLeft(new BTNode(element, null, null));
					break;
				}
			} else {
				BTNode next = cursor.getRight();
				if (next != null) {
					cursor = next;
				} else {
					cursor.setRight(new BTNode(element, null, null));
					break;
				}
			}
		}
	}

	// 使用add方法编写addTree方法
	// 将一个排序二叉树的全部节点加到另一个里面
	public void addTree(BTNode addroot) {
		// 先序递归调用add方法
		if (addroot != null) {
			this.add((int) addroot.getData());
			this.addTree(addroot.getLeft());
			this.addTree(addroot.getRight());
		}
	}
}
