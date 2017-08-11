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
		// 实现深复制
		BTNode aNew = BTNode.copyTree(this.root);
		return new TreeBagSou(aNew);
	}

	// 二叉搜索树查找节点
	public static BTNode SearchInBSTtree(TreeBagSou root, int target) {
		BTNode p = root.getRoot();
		BTNode answer = null;
		boolean flag = false;
		while (p != null && !flag) {
			if ((int) p.getData() < target) {
				p = p.getRight();
			} else if ((int) p.getData() == target) {
				flag = true;
				answer = p;
			} else {
				p = p.getLeft();
			}
		}
		return answer;
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

		} else {
			// 寻找插入点
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
	}

	// BST的删除节点算法(3种情况+一种空树的情况)
	public boolean deleteNodeInBST(int target) {
		BTNode cursor = root;
		BTNode parent = null;
		if (cursor == null) {
			return false;
		}
		while (true) {
			if (cursor == null) {
				break;
			} else {

				if ((int) cursor.getData() < target) {
					parent = cursor;
					cursor = cursor.getRight();
				} else if ((int) cursor.getData() > target) {
					parent = cursor;
					cursor = cursor.getLeft();
				} else {
					// 在树中
					break;
				}
			}
		}
		if (cursor == null) {
			return false;
		} else {
			// 情况1 cursor指向根节点 但是没有左孩子
			if (cursor == root && cursor.getLeft() == null) {
				cursor = cursor.getRight();
				root = cursor;
			} else if (cursor.getLeft() == null) {
				// 情况2 待删除的节点没有左孩子(右孩子不知道有没有)
				if (cursor == parent.getLeft()) {
					// 待删除的节点在父节点左面
					parent.setLeft(cursor.getRight());
				} else {
					// 待删除的节点在父节点右面
					parent.setRight(cursor.getRight());
				}
			} else {
				// 情况3 待删除节点有左孩子(或左子树) 从左子树中找一个来替代删除节点的值
				// 这个值是它左子树中最右面的元素(最大元素)
				cursor.setData(cursor.getLeft().getRightMostData());
				cursor.setLeft(cursor.getLeft().removeRightMost());
			}
			return true;
		}
	}

	// 使用add方法编写addTree方法
	// 将一个排序二叉树的全部节点加到另一个里面
	public void addTree(BTNode addroot) {
		// 先序递归调用add方法
		if (addroot != null) {
			this.add((int) addroot.getData());
			// 递归
			this.addTree(addroot.getLeft());
			this.addTree(addroot.getRight());
		}
	}
}
