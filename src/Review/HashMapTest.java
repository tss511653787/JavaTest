package Review;

public class HashMapTest {
	public static void main(String[] args) {
		ReviewHashMap map = new ReviewHashMap();
		map.put(1, "abc");
		map.put(2, "bbb");
		map.put(1, "aaa");
		map.put(3, "666");
		System.out.println(map.get(1));
		System.out.println(map.get(2));
		System.out.println(map.remove(5));
		System.out.println(map.remove(1));
		System.out.println(map.get(1));
		System.out.println(map.put(2, "newValue"));
		System.out.println(map.get(2));

	}

}
