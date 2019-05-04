package Review;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/*
 * 获得一个并发集视图 其实Current包中并没有并发集(set)
 * */
public class CucurrentSer {
	public static void main(String[] args) {
		ConcurrentMap<String, Integer> cuConcurrentMap = new ConcurrentHashMap<>();
		Set<String> CunrrentSet = cuConcurrentMap.keySet();
		CunrrentSet.forEach(x -> System.out.println(x));
	}
}
