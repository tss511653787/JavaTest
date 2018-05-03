/**
 * 
 */
package Test5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.Timer;

/**
 * @author Administrator
 *
 */
public class LambdaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "abc";
		String str2 = "b";
		Comparator<String> comparator = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.length() - o2.length();
			}
		};
		Comparator<String> com = (String s, String b) -> (s.length() - b
				.length());
		String[] words = { "aaa", "bbb", "ccc", "dddd" };
		Arrays.sort(words, (a, b) -> a.length() - b.length());
		Timer t = new Timer(1000, event -> System.out.println(event));
		t.start();
		Arrays.asList(words).forEach(x -> System.out.print(x + " "));
		repeat(10, () -> System.out.print("abc"));
		

	}

	public static void repeat(int num, Runnable action) {
		for (int i = 0; i < num; i++) {
			action.run();
		}
	}
}
