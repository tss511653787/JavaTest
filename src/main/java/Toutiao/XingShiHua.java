package Toutiao;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Stack;

public class XingShiHua {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String strIn = scan.nextLine();
		// 有可能用到中缀表达式求值
		// 假设只有2个数
		Stack<Integer> num = new Stack<>();
		Stack<Character> col = new Stack<>();
		for (int i = 0; i < strIn.length(); i++) {
			char a = strIn.charAt(i);
			if (a >= '0' && a <= '9') {
				num.push(Integer.parseInt(String.valueOf(a)));
			} else {
				// 是符号
				col.push(a);
			}
		}
		char co = col.pop();
		int second = num.pop();
		int first = num.pop();
		String answer = null;
		switch (co) {
		case '+':
			answer = String.valueOf((first + second));
			break;
		case '-':
			answer = String.valueOf((first - second));
			break;
		case '*':
			answer = String.valueOf((first * second));
			break;
		case '/':
			double temp = first / second;
			DecimalFormat df = new DecimalFormat("######0.00");
			df.format(temp);
			answer = String.valueOf(temp);
			break;
		default:
			break;
		}
		String input = String.valueOf(first) + String.valueOf(co)
				+ String.valueOf(second) + "=" + answer;
		// trans
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			switch (c) {
			case '0':
				System.out.println("***");
				System.out.println("* *");
				System.out.println("* *");
				System.out.println("* *");
				System.out.print("***");
				break;
			case '1':
				System.out.println(" * ");
				System.out.println(" * ");
				System.out.println(" * ");
				System.out.println(" * ");
				System.out.print(" * ");

				break;
			case '2':
				System.out.println("***");
				System.out.println("  *");
				System.out.println("***");
				System.out.println("*  ");
				System.out.println("***");

				break;
			case '3':
				System.out.println("***");
				System.out.println("  *");
				System.out.println("***");
				System.out.println("  *");
				System.out.println("***");

				break;
			case '4':
				System.out.println("* *");
				System.out.println("* *");
				System.out.println("***");
				System.out.println("  *");
				System.out.println("  *");

				break;
			case '5':
				System.out.println("***");
				System.out.println("*  ");
				System.out.println("***");
				System.out.println("  *");
				System.out.println("***");

				break;
			case '6':
				System.out.println("***");
				System.out.println("*  ");
				System.out.println("***");
				System.out.println("* *");
				System.out.println("***");

				break;
			case '7':
				System.out.println("***");
				System.out.println("  *");
				System.out.println("  *");
				System.out.println("  *");
				System.out.println("  *");

				break;
			case '8':
				System.out.println("***");
				System.out.println("* *");
				System.out.println("***");
				System.out.println("* *");
				System.out.println("***");

				break;
			case '9':
				System.out.println("***");
				System.out.println("* *");
				System.out.println("* *");
				System.out.println("  *");
				System.out.println("***");

				break;
			case '+':
				System.out.println("   ");
				System.out.println(" * ");
				System.out.println("***");
				System.out.println(" * ");
				System.out.println("   ");

				break;
			case '-':
				System.out.println("   ");
				System.out.println("   ");
				System.out.println("***");
				System.out.println("   ");
				System.out.println("   ");

				break;
			case '*':
				System.out.println("   ");
				System.out.println("* *");
				System.out.println(" * ");
				System.out.println("* *");
				System.out.println("   ");

				break;
			case '/':
				System.out.println("   ");
				System.out.println("  *");
				System.out.println(" * ");
				System.out.println("*  ");
				System.out.println("   ");

				break;
			case '=':
				System.out.println("    ");
				System.out.println("****");
				System.out.println("    ");
				System.out.println("****");
				System.out.println("    ");

				break;
			case '.':
				System.out.println("   ");
				System.out.println("   ");
				System.out.println("   ");
				System.out.println(" **");
				System.out.println(" **");

				break;

			default:
				break;
			}
			System.out.println("  ");
		}
	}

}
