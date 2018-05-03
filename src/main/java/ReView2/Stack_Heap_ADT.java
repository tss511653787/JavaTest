package ReView2;

import java.util.*;

/*
 * 题目：实现一个ADT 使其实现stack 和heap特性 并有下列方法 size获取容器当前元素个数 push往容器中添加一个元素
 * stack_pop 栈特性的弹栈操作 取到最近一次压入得元素 heap_pop 堆特性的出堆操作 取到其中最大的一个元素
 */
public class Stack_Heap_ADT {
	static int id = 0;
	static int size = 0;
	static Stack<Element> stk = new Stack<>();
	static PriorityQueue<Element> heap = new PriorityQueue<>(
			new Comparator<Element>() {
				@Override
				public int compare(Element o1, Element o2) {
					// TODO Auto-generated method stub
					if (o1.value > o2.value) {
						return -1;
					} else if (o1.value < o2.value) {
						return 1;
					} else {
						return 0;
					}
				}
			});
	static Set<Integer> set = new HashSet<>();

	public static void main(String[] args) {
		Stack_Heap_ADT adt = new Stack_Heap_ADT();
		adt.push(1);
		adt.push(3);
		adt.push(2);
		adt.push(7);
		adt.push(11);
		adt.push(20);
		adt.push(2);
		System.out.println(adt.heap_pop());
		System.out.println(adt.heap_pop());
		System.out.println(adt.heap_pop());
		System.out.println(adt.stack_pop());
		System.out.println(adt.stack_pop());
		System.out.println(adt.stack_pop());
	}

	/*
	 * 元素类 inner class
	 */
	class Element {
		int value;
		int id;

		public Element(int value) {
			this.value = value;
			id = getId();
		}
	}

	private int getId() {
		return ++id;
	}

	public int size() {
		return size;
	}

	public void push(int target) {
		Element e = new Element(target);
		stk.push(e);
		heap.offer(e);
		size++;
	}

	public int stack_pop() {
		Element out = null;
		while (true) {
			out = stk.pop();
			if (set.contains(out.id)) {
				continue;
			} else {
				break;
			}
		}

		heap.remove(out);
		set.remove(out.id);
		return out.value;
	}

	public int heap_pop() {
		Element out = heap.poll();
		set.add(out.id);
		return out.value;
	}
}
