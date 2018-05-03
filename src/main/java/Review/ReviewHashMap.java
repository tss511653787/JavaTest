package Review;

/*
 *复习写一个hashMap ADT
 *hash函数使用除留余数法
 *链表法解决冲突
 * */

public class ReviewHashMap {
	private final static int defaultLength = 16;
	private final int num = 5;
	HashNode[] array = new HashNode[defaultLength];
	static int modcount = 0;
	static int Threshold = (int) (defaultLength * 0.75);

	public int capacity() {
		return defaultLength;
	}

	/*
	 * put 方法插入成功返回插入值 替换插入返回被替换值
	 */
	public String put(int key, String value) {
		// 判断是否需要扩容
		if (modcount > Threshold) {
			resize();
		}
		int i = hash(key);
		if (array[i] == null) {
			array[i] = new HashNode(key, value, null);
			return value;
		} else {
			HashNode p = array[i];
			HashNode r = array[i];
			while (p.key != key) {
				if (p.next != null) {
					p = p.next;
				}
			}
			if (p.key == key) {
				String old = p.value;
				p.value = value;
				return old;
			} else {
				// 头插
				r.next = new HashNode(key, value, r.next);
				return value;
			}
		}
	}

	private void resize() {
		// TODO Auto-generated method stub
		// hash表的扩容方法
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
	public String remove(int key) {
		int i = hash(key);
		if (array[i] == null) {
			return null;
		} else {
			HashNode p = array[i];
			HashNode r = array[i];
			while (p.key != key) {
				if (p.next != null) {
					p = p.next;
				} else {
					break;
				}
			}
			if (p.key == key) {
				while (r.next != p) {
					if (r.next != null) {
						r = r.next;
					} else {
						break;
					}
				}
				if (p == array[i]) {
					String res = p.value;
					array[i] = array[i].next;
					return res;
				} else {
					String res = p.value;
					r.next = p.next;
					return res;
				}
			} else {
				// 未找到
				return null;
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
