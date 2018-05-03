package offer;

import java.util.Stack;

public class Solution {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void push(int node) {
		stack1.push(node);
	}

	public int pop() {
		while (!stack1.isEmpty()) {
			if (stack2.isEmpty()) {
				stack2.push(stack1.pop());
			} else {
				break;
			}
		}
		return stack2.pop();
	}

	public static void main(String[] args) {
		Solution a = new Solution();
		int[] array = { 3, 4, 5, 6, 1, 2 };
		System.out.println(minNumberInRotateArray(array));

	}

	public static int minNumberInRotateArray(int[] array) {
		int len = array.length;
		int answer;
		int left = 0;
		int right = len - 1;
		int mid = 0;
		if (len == 0)
			return 0;
		while ((right - left) != 1) {
			mid = left + (right - left) / 2;
			if (array[right] >= array[mid])
				right = mid;
			else if (array[left] <= array[mid])
				left = mid;
		}
		if (array[right] > array[left])
			return array[left];
		else
			return array[right];

	}
}
