package test3;

/*
 * 堆元素 包含数据和优先级标识
 * */
public class HeapElement {
	private int Priority;
	private Object data;

	public HeapElement(int priority, Object data) {
		super();
		Priority = priority;
		this.data = data;
	}

	public int getPriority() {
		return Priority;
	}

	public void setPriority(int priority) {
		Priority = priority;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
