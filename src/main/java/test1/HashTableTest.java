package test1;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;

public class HashTableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashtable<Integer, Double> table = new Hashtable<Integer, Double>();
		table.put(1, 0.125);
		table.put(2, 2.125);
		table.put(3, 3.125);
		Iterator<Integer> iter = table.keySet().iterator();
		while (iter.hasNext()) {
			Integer num = (Integer) iter.next();
			System.out.println(num + " " + table.get(num));
		}
		Double key = table.get(2);
		table.put(2, key + 5);
		Iterator<Integer> Iter = table.keySet().iterator();
		while (Iter.hasNext()) {
			Integer num = (Integer) Iter.next();
			System.out.println(num + " " + table.get(num));
		}
	}
}
