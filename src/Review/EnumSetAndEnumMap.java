package Review;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Set;

public class EnumSetAndEnumMap {
	/*
	 * 集合中的枚举类型复习
	 */
	public static void main(String[] args) {
		// Enumse
		EnumSet<Number> num_enumSet = EnumSet.allOf(Number.class);
		for (Number n : num_enumSet) {
			System.out.println(n);
		}
		System.out.println("----------------");
		// EnumMap
		EnumMap<Number, Employee> Number_map = new EnumMap<>(Number.class);
		Set<Number> Number_mao_ketSet = Number_map.keySet();
		for (Number n : Number_mao_ketSet) {
			System.out.println(n + " " + Number_map.get(n));
		}
	}
}

enum Number {
	One, Two, Three
}

enum Employee {
	TSS, ZMH, LP
}
