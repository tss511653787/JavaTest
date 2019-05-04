package test;

import java.lang.annotation.Target;
import java.util.*;

import static ReView2.TenSortOptimize.JiShuSort;

public class tes1 {

    public static void main(String[] args) {
        //输出二叉树跟到叶子的全部路径
//        lastPrintTree(initTestTree());
        //给定深度建个满二叉树
//        TreeNode root = makeTreeWithDeep(4);
//        printTree(root);
//        System.out.println(makeTreeNumDeep(4, 1, 5, 217));
        int[] nums = {2, 8, -1, 90, 11, 31, 53, 12, 32};
//        JiShuSort(nums);
//        insertSort(nums);
        int target = -1;
        System.out.println(binarySearch(nums, target));
    }

    private static int binarySearch(int[] nums, int target) {
        //sort
        Arrays.sort(nums);
        return binary(nums, 0, nums.length - 1, target);
    }

    private static int binary(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        } else {
            int mid = (low + high) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                return binary(nums, mid + 1, high, target);
            } else {
                return binary(nums, low, mid - 1, target);
            }
        }
    }

    //中序编列二叉树
    public static void printTree(TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        while (null != p || !stack.isEmpty()) {
            if (null != p) {
                stack.push(p);
                p = p.getLeftChild();
            } else {
                TreeNode out = stack.pop();
                System.out.print(out.getValue() + " ");
                p = out.getRightChild();
            }
        }
    }

    //后续编列二叉树
    public static void lastPrintTree(TreeNode node) {
        if (null == node) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (null != node || !stack.isEmpty()) {
            while (null != node) {
                stack.push(node);
                node = node.getLeftChild();
            }
            if (!stack.isEmpty()) {
                TreeNode out = stack.pop();
                if (!out.isIsout()) {
                    out.setIsout(true);
                    stack.push(out);
                    node = out.getRightChild();
                } else {
                    System.out.print(out.getValue() + " ");
                }
            }
        }
    }

    private static TreeNode makeTreeWithDeep(int deep) {
        int[] num = new int[(int) Math.pow(2, deep) - 1];
        for (int i = 0; i < num.length; i++) {
            num[i] = i + 1;
        }
        return makeTree(null, num, 0, num.length - 1);
    }

    private static TreeNode makeTree(TreeNode p, int[] num, int low, int high) {
        if (low > high) {
            return null;
        } else {
            int mid = (low + high) / 2;
            p = new TreeNode(null, null, num[mid]);
            p.setLeftChild(makeTree(p.getLeftChild(), num, low, mid - 1));
            p.setRightChild(makeTree(p.getRightChild(), num, mid + 1, high));
        }
        return p;
    }

    /**
     * 给定三个数返回最小的跟（如果没找到则返回-1）
     */
    private static int makeTreeNumDeep(int deep, int a, int b, int c) {
        int[] num = new int[(int) Math.pow(2, deep) - 1];
        for (int i = 0; i < num.length; i++) {
            num[i] = i + 1;
        }
        List<Integer> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        return findSmallRoot(num, Collections.min(list), Collections.max(list), 0, num.length - 1);
    }

    public static int findSmallRoot(int[] nums, int min, int max, int low, int high) {
        if (low > high || min < nums[0] || max > nums[nums.length - 1]) {
            return -1;
        } else {
            int mid = (low + high) / 2;
            int midNum = nums[mid];
            if (midNum >= min && midNum <= max) {
                return midNum;
            } else if (midNum < min) {
                return findSmallRoot(nums, min, max, mid + 1, high);
            } else {
                return findSmallRoot(nums, min, max, low, mid - 1);
            }
        }
    }

    /**
     * 给定字符输出全排序
     */
    public static void outPrintAll(LinkedList<String> list, String buffer) {
        if (list.isEmpty()) {
            System.out.println(buffer);
        } else {
            for (int i = 0; i < list.size(); i++) {
                LinkedList<String> tmp = (LinkedList<String>) list.clone();
                outPrintAll(tmp, buffer + tmp.remove(i));
            }
        }
    }

    /**
     * 快排
     */
    public static void quickSort(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        outQuickSort(nums, low, high);
    }

    private static void outQuickSort(int[] nums, int low, int high) {
        if (low < high) {
            int tag = quick(nums, low, high);
            outQuickSort(nums, low, tag - 1);
            outQuickSort(nums, tag + 1, high);
        }
    }

    private static int quick(int[] nums, int low, int high) {
        int target = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= target) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] < target) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[high] = target;
        return high;
    }

    /**
     * 归并排序
     */
    public static void mSort(int[] nums) {
        mergeSort(nums, 0, nums.length);
    }

    private static void mergeSort(int[] nums, int first, int n) {
        if (n > 1) {
            int n1 = n / 2;
            int n2 = n - n1;
            mergeSort(nums, first, n1);
            mergeSort(nums, first + n1, n2);
            merge(nums, first, n1, n2);
        }
    }

    private static void merge(int[] nums, int first, int n1, int n2) {
        int[] copyNums = new int[n1 + n2];
        int copyed = 0;
        int copyed1 = 0;
        int copyed2 = 0;
        while (copyed1 < n1 && copyed2 < n2) {
            if (nums[first + copyed1] < nums[first + n1 + copyed2]) {
                copyNums[copyed++] = nums[first + copyed1++];
            } else {
                copyNums[copyed++] = nums[first + n1 + copyed2++];
            }
        }
        while (copyed1 < n1) {
            copyNums[copyed++] = nums[first + copyed1++];
        }
        while (copyed2 < n2) {
            copyNums[copyed++] = nums[first + n1 + copyed2++];
        }
        for (int i = 0; i < n1 + n2; i++) {
            nums[first + i] = copyNums[i];
        }
    }

    /**
     * 插入排序
     */
    public static void insertSort(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            int k = 0;
            int target = nums[i];
            while (k < i) {
                if (nums[k] > target) {
                    break;
                } else {
                    k++;
                }
            }
            int m = i;
            while (m > k) {
                nums[m] = nums[m - 1];
                m--;
            }
            nums[k] = target;
        }
    }

    /**
     * 使用collections排序实现就排序
     */
    public static void jiOuSort(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        list.sort((n1, n2) -> {
            if (0 == Math.abs(n1) % 2 - Math.abs(n2) % 2) {
                return n1 - n2;
            } else {
                if (0 != n1 % 2) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
    }


    private static void outPutPath(TreeNode treeNode) {
        LinkedList<TreeNode> list = new LinkedList<>();
        outPath(treeNode, list);
    }

    private static void outPath(TreeNode treeNode, LinkedList<TreeNode> list) {
        if (null == treeNode) {
            return;
        }
        list.add(treeNode);
        if (null == treeNode.getLeftChild() && null == treeNode.getRightChild()) {
            list.forEach(node -> System.out.print(node.getValue() + " "));
            System.out.println();
        }
        outPath(treeNode.getLeftChild(), list);
        outPath(treeNode.getRightChild(), list);
        list.removeLast();
    }

    public static TreeNode initTestTree() {
        TreeNode root = new TreeNode(null, null, 1);
        root.setLeftChild(new TreeNode(null, null, 2));
        root.setRightChild(new TreeNode(null, null, 3));
        root.getLeftChild().setLeftChild(new TreeNode(null, null, 4));
        root.getLeftChild().setRightChild(new TreeNode(null, null, 5));
        root.getRightChild().setLeftChild(new TreeNode(null, null, 6));
        return root;
    }
}

class TreeNode {
    private TreeNode leftChild;
    private TreeNode rightChild;
    private int value;
    private boolean isout;

    public TreeNode(TreeNode leftChild, TreeNode rightChild, int value) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.value = value;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isIsout() {
        return isout;
    }

    public void setIsout(boolean isout) {
        this.isout = isout;
    }

    public TreeNode deleteMostRight() {
        if (rightChild == null) {
            return leftChild;
        } else {
            rightChild = rightChild.deleteMostRight();
            return this;
        }
    }
}

class B {
    public static B t1 = new B();
    public static B t2 = new B();

    static {
        System.out.println("static block.");
    }

    {
        System.out.println("no static block.");
    }

    public static void main(String[] args) {
        B b = new B();
    }
}

