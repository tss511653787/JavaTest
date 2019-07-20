package test;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author tss2019
 * @version 1.0
 * @date 2019/4/29
 */
public class Test2 {
    /**
     * test main
     */
    public static void main(String[] args) throws FileNotFoundException {
//        TreeNode root = initailBSTree();
//        deleteInBST(1, root);
//        tes1.printTree(root);
//        System.out.println();
//        reviewWC();

        String[] strs = {"a1", "a2", "a3", "a4", "a5", "b1", "b2", "b3", "b4", "b5"};
        changeLocation(strs, 5);

    }

    private static void changeLocation(String[] strs, int n) {
        for (int i = n; i < strs.length - 1; i++) {
            int k = i;
            for (int j = strs.length - 1 - i; j > 0; j--) {
                swap(strs, k, k - 1);
                k--;
            }
        }
    }

    private static void swap(String[] strs, int k, int i) {
        String tmp = strs[k];
        strs[k] = strs[i];
        strs[i] = tmp;
    }


    public static void reviewWC() throws FileNotFoundException {
        File file = new File("/Users/tss/Downloads/str1");
        StringBuilder builder = new StringBuilder();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            builder.append(scanner.nextLine());
        }
        String[] strings = builder.toString().split("\\s+");
        Map<String, Integer> map = new TreeMap<>();
        for (String s : strings) {
            map.put(s, map.getOrDefault(s, 1) + 1);
        }
        Set<Map.Entry<String, Integer>> set = new TreeSet<>((o1, o2) -> {
            if (o1.getValue() > o2.getValue()) {
                return -1;
            } else {
                return 1;
            }
        });
        Set<Map.Entry<String, Integer>> setx = map.entrySet();
        set.addAll(setx);
        set.forEach(en -> System.out.println(en.getKey() + " " + en.getValue()));
    }

    public static TreeNode initailBSTree() {
        TreeNode root = new TreeNode(null, null, 4);
        root.setLeftChild(new TreeNode(null, null, 2));
        root.setRightChild(new TreeNode(null, null, 6));

        root.getLeftChild().setLeftChild(new TreeNode(null, null, 1));
        root.getLeftChild().setRightChild(new TreeNode(null, null, 3));

        root.getRightChild().setLeftChild(new TreeNode(null, null, 5));
        root.getRightChild().setRightChild(new TreeNode(null, null, 7));

        return root;
    }

    /**
     * search in bst
     */
    public static boolean searchInBST(int target, TreeNode p) {
        if (null == p) {
            return false;
        } else {
            if (target == p.getValue()) {
                return true;
            } else if (target > p.getValue()) {
                return searchInBST(target, p.getRightChild());
            } else {
                return searchInBST(target, p.getLeftChild());
            }
        }
    }

    /**
     * inset in BST
     */
    public static void insertInBST(int target, TreeNode p) {
        TreeNode parent = p;
        while (null != p) {
            if (p.getValue() > target) {
                parent = p;
                p = p.getLeftChild();

            } else {
                parent = p;
                p = p.getRightChild();
            }
        }
        //null==p
        if (parent.getValue() >= target) {
            parent.setLeftChild(new TreeNode(null, null, target));
        } else {
            parent.setRightChild(new TreeNode(null, null, target));
        }
    }

    /**
     * delete in BST
     */
    public static void deleteInBST(int target, TreeNode p) {
        TreeNode parent = p;
        while (null != p) {
            if (target == p.getValue()) {
                break;
            } else if (target > p.getValue()) {
                parent = p;
                p = p.getRightChild();
            } else {
                parent = p;
                p = p.getLeftChild();
            }
        }
        if (null == p) {
            return;
        }
        if (parent == p && null == p.getLeftChild()) {
            parent = p.getRightChild();
            p.setLeftChild(null);
        }
        if (null == p.getLeftChild()) {
            if (parent.getLeftChild() == p) {
                parent.setLeftChild(p.getRightChild());
            } else {
                parent.setRightChild(p.getRightChild());
            }
        }
        if (null != p.getLeftChild()) {
            int mostRightChildValue = getMostRightChildValue(p.getLeftChild());
            p.setValue(mostRightChildValue);
            p.setLeftChild(p.getLeftChild().deleteMostRight());
        }
    }


    private static int getMostRightChildValue(TreeNode p) {
        while (p.getRightChild() != null) {
            p = p.getRightChild();
        }
        return p.getValue();
    }

}
