package ZUO;

import freemarker.ext.beans.HashAdapter;

import java.util.*;

/**
 * @author tss2019
 * @version 1.0
 * @date 2019/6/2
 */
public class StackAndQueue {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.forEach(System.out::println);
        System.out.println();
        reverseStack(stack);
        stack.forEach(System.out::println);
    }

    /**
     * 仅使用递归实现一个栈的逆序
     * 空间复杂度O(1)
     */
    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        } else {
            int res = getButtonFromStack(stack);
            reverseStack(stack);
            stack.push(res);
        }
    }

    public static int getButtonFromStack(Stack<Integer> stack) {
        int res = stack.pop();
        if (stack.isEmpty()) {
            return res;
        } else {
            int tmp = getButtonFromStack(stack);
            stack.push(res);
            return tmp;
        }
    }
}
