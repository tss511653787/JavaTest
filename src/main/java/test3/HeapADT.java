/**
 * 
 */
package test3;

import java.util.AbstractQueue;

import javax.lang.model.element.Element;

/**
 * @author dell
 *
 */
// 堆ADT实现
public class HeapADT {
	/*
	 * 用数组实现堆 PriorityQueue<E> extends AbstractQueue<E> 也使用数组实现优先级队列
	 */
	HeapElement[] queue;
	private int size = defaultMaxLength;
	// 定义默认长度
	private final static int defaultMaxLength = 11;

	private int getSize() {
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (queue[i] != null) {
				count++;
			} else {
				break;
			}
		}
		return count;
	}

	public HeapADT() {
		super();
		queue = new HeapElement[defaultMaxLength];
	}

	public HeapADT(int size) {
		super();
		this.size = size;
		queue = new HeapElement[size];
	}

	public void insertInHeap(HeapElement element) {
		if (getSize() >= defaultMaxLength) {
			System.out.println("Heap full");
			return;
		} else {
			int cur = getSize();
			queue[cur] = element;
			makeHeap(queue);
		}
	}

	private void makeHeap(HeapElement[] queue2) {
		// TODO Auto-generated method stub
		// 从后向前调堆
		HeapElement temp;
		for (int i = getSize() - 1; i > 0; i--) {
			if (i % 2 == 0) {
				// 是右孩子
				if (queue[i].getPriority() > queue[i / 2 - 1].getPriority()) {
					temp = queue[i / 2 - 1];
					queue[i / 2 - 1] = queue[i];
					queue[i] = temp;
				}
			} else {
				// 是左孩子
				if (queue[i].getPriority() > queue[i / 2].getPriority()) {
					temp = queue[i / 2];
					queue[i / 2] = queue[i];
					queue[i] = temp;
				}
			}
		}
	}

	// 堆顶出堆操作
	public HeapElement outOfHeap() {
		/*
		 * 堆顶出堆 将最后一个元素放到堆顶
		 */
		if (getSize() == 0) {
			return null;
		} else {
			HeapElement answer = queue[0];
			queue[0] = queue[getSize() - 1];
			makeHeap(queue);
			return answer;
		}
	}
}
