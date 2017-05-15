package test3;

public class MyHashMapNode {
	Object key;
	Object value;
	MyHashMapNode link;

	public MyHashMapNode(Object key, Object value, MyHashMapNode link) {
		this.key = key;
		this.value = value;
		this.link = link;
	}

	public Object getKey() {
		return key;
	}

	public void setKey(Object key) {
		this.key = key;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public MyHashMapNode getLink() {
		return link;
	}

	public void setLink(MyHashMapNode link) {
		this.link = link;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getKey() + " " + this.getValue();
	}

	// 这个地方要重写equals方法 用于比较每个node中的value值
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		MyHashMapNode o = (MyHashMapNode) obj;
		if (this.getValue() == o.getValue()) {
			return true;
		} else {
			return false;
		}
	}

}
