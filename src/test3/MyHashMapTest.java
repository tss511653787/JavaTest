package test3;

public class MyHashMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyHashMap map = new MyHashMap();
		map.put(1, 90);
		map.put(1, 100);
		map.put(1, 50);
		map.put(3, 12);
		map.put(4, 16);
		map.put(4, 70);
		map.put(8, 15);

		System.out.println(map.get(1));
		System.out.println(map.get(4));
		System.out.println(map.get(3));
		System.out.println(map.get(8));
		System.out.println(map.get(3));

	}
}
