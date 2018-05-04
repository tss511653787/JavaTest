package JD_9;

import java.util.Scanner;
import java.util.Stack;

public class pro1 {
    static Scanner scanner = new Scanner(System.in);
    private Stack<Character> stk;

    public static void main(String[] args) {
        String s = new String("abc");
        while (scanner.hasNext()) {
            String in = scanner.nextLine();
            if (in.equals("")) {
                System.out.print(0);
            } else {
                int number = 1;
                Stack<Character> stk;
                stk = new Stack<>();
                for (int i = 0; i < in.length(); i++) {
                    char c = in.charAt(i);
                    if (c == '(')
                        stk.push(c);
                    else {
                        number = Math.max(number, stk.size());
                        stk.pop();
                    }
                }
                System.out.print(number);
            }
        }
    }
}
