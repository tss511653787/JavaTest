package HuaWeiTest;

import java.util.Arrays;
import java.util.Stack;
import java.util.Vector;

//定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。

public class NiuKeStack {
	private Stack<Integer> stk = new Stack<Integer>();

	public void push(int node) {
		stk.push(node);
	}

	public void pop() {
		if (!stk.isEmpty()) {
			stk.pop();
		}
	}

	public int top() {
		return stk.peek();
	}

	public int min() {
		if (!stk.isEmpty()) {
			Vector<Integer> vec = (Vector<Integer>) stk.clone();
			int min = Integer.MAX_VALUE;
			for (Integer i : vec) {
				if (i < min)
					min = i;
			}
			return min;
		} else
			return 0;
	}

	public static void main(String[] args) {
		NiuKeStack st = new NiuKeStack();
		st.push(3);
		st.push(0);
		st.push(-1);
		st.push(2);
		st.push(2);
		st.push(2);
		st.push(3);
		st.push(3);
		System.out.println(st.min());
	}
}
