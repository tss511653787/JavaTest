package HuaWeiTest;

import java.util.Scanner;

public class HasNext {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		// scan.useDelimiter("\n");
		String[] in1 = scan.nextLine().split(".");
		for (String s : in1) {
			System.out.print(s + " ");
		}
	}
}
