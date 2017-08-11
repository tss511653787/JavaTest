package Review;

/*
 *复习写一个hashMap
 *hash函数使用除留余数法
 *链表法解决冲突
 * */

public class ReviewHashMap {
	private final static int defaultLength = 10;
	private final int num = 5;
	HashNode[] array = new HashNode[defaultLength];

	public int capacity() {
		return defaultLength;
	}

	/*
	 * put 方法插入成功返回插入值 替换插入返回被替换值
	 */
	public String put(int key, String value) {
		int hash = hash(key);
		if (array[hash] == null) {
			array[hash] = new HashNode(key, value, null);
			return value;
		} else {
			HashNode cursor = array[hash];
			while (cursor != null) {
				if (cursor.key != key) {
					cursor = cursor.next;
				} else {
					break;
				}
			}
			if (cursor != null) {
				String old = cursor.value;
				cursor.value = value;
				return old;
			} else {
				// cursor==null
				cursor = array[hash];
				while (cursor.next != null) {
					cursor = cursor.next;
				}
				cursor.next = new HashNode(key, value, null);
				return value;
			}
		}
	}

	/*
	 * get
	 */
	public String get(int key) {
		int hash = hash(key);
		if (array[hash] == null) {
			// 未找到
			return null;
		} else {
			HashNode cursor = array[hash];
			while (cursor != null) {
				if (cursor.key != key) {
					cursor = cursor.next;
				} else {
					break;
				}
			}
			if (cursor == null) {
				return null;
			} else {
				return cursor.value;
			}
		}
	}

	/*
	 * remove
	 */
	public boolean remove(int key) {
		int hash = hash(key);
		if (array[hash] == null) {
			return false;
		} else {
			HashNode cursor = array[hash];
			while (cursor != null) {
				if (cursor.key != key) {
					cursor = cursor.next;
				} else {
					break;
				}
			}
			if (cursor == null) {
				return false;
			} else {
				if (cursor == array[hash]) {
					array[hash] = null;
					return true;
				} else {
					HashNode p = array[hash];
					while (p.next != cursor) {
						p = p.next;
					}
					p.next = cursor.next;
					return true;
				}
			}
		}
	}

	/*
	 * hash函数 除留余数法
	 */
	private int hash(int key) {
		return key % num;
	}
}

class HashNode {
	int key;
	String value;
	HashNode next;

	public HashNode(int key, String value, HashNode next) {
		super();
		this.key = key;
		this.value = value;
		this.next = next;
	}

}
