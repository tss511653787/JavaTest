package test;


import java.util.LinkedList;

/**
 * @author tss2019
 * @version 1.0
 * @date 2019/5/11
 */
public class AboutQueue {
    public static void main(String[] args) throws Exception {
        MyQueue queue = new MyQueue(5);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        for (int i = 0; i < 4; i++) {
            System.out.println(queue.poll());
        }
        TreeNode root = tes1.makeTreeWithDeep(3);
        cengCiPrintTree(root);
    }

    /**
     * queue print tree
     */
    public static void cengCiPrintTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (null == root) {
            return;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode out = queue.poll();
            System.out.print(out.getValue() + " ");
            if (null != out.getLeftChild()) {
                queue.offer(out.getLeftChild());
            }
            if (null != out.getRightChild()) {
                queue.offer(out.getRightChild());
            }
        }
    }

}

class MyQueue {
    int front;
    int rear;
    int size;
    int count;
    int[] nums;

    public MyQueue(int size) {
        this.size = size;
        nums = new int[size];
        front = 0;
        rear = front;
        count = 0;
    }

    public void offer(int target) throws Exception {
        if (count != 0 && (rear + 1) % size == front) {
            throw new Exception("Queue is full");
        }
        nums[rear] = target;
        rear = (rear + 1) % size;
        count++;
    }

    public int poll() throws Exception {
        if (count == 0 && front == rear) {
            throw new Exception("Queue is empty");
        }
        count--;
        int res = nums[front];
        front = (front + 1) % size;
        return res;
    }
}
