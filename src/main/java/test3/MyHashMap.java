package test3;

//链式散列实现一个自己的Hashmap链表

public class MyHashMap {
	// table 存放MyHashNode中key的hash值
	MyHashMapNode[] table;
	// 默认的长度
	final static int DEFAULT_LENGTH = 5;
	private int size;

	public int getSize() {
		return size;
	}

	// 构造器
	public MyHashMap() {
		table = new MyHashMapNode[DEFAULT_LENGTH];
		size = DEFAULT_LENGTH;
	}

	public MyHashMap(int size) {
		table = new MyHashMapNode[size];
		this.size = size;
	}

	// 自定义hash函数
	public static int hashMethod(int hashnum, int length) {
		return hashnum % length;
	}

	// 实现MyHashMap的put和get方法
	public Object get(Object key) {
		// 返回的值是MyHashNode的Value值
		int hashnum = key.hashCode();
		int hash = hashMethod(hashnum, size);
		if (table[hash] == null) {
			return null;
		} else {
			MyHashMapNode cursor = table[hash];
			Object answer = null;
			while (cursor != null) {
				if (cursor.getKey() == key) {
					answer = cursor.getValue();
					break;
				} else {
					cursor = cursor.getLink();
				}
			}
			return answer;
		}
	}

	public Object put(Object key, Object value) {
		// 如果原来没有这个key value值则新加入并返回null
		// 如果原来有这个key值就替换原来的value值并返回原来的value
		int hashnum = key.hashCode();
		int hash = hashMethod(hashnum, size);
		MyHashMapNode cursor;
		if (table[hash] == null) {
			cursor = new MyHashMapNode(key, value, null);
			// cursor.setLink(table[hash]);
			table[hash] = cursor;
			return null;
		} else {
			Object answer = null;
			cursor = table[hash];
			while (cursor != null) {
				if (cursor.getKey().hashCode() == key.hashCode()) {
					answer = cursor.getValue();
					cursor.setValue(value);
					break;
				} else {
					cursor = cursor.getLink();
				}
			}
			// 没有找到可key相同的值
			if (cursor == null) {
				// key的hash相同 插入到链表中
				cursor = new MyHashMapNode(key, value, null);
				MyHashMapNode find = table[hash];
				// 再次搜索倒数以一个位置
				while (find.getLink() != null) {
					find = find.getLink();
				}
				find.setLink(cursor);
			}
			return answer;
		}

	}
}
