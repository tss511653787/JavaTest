package Offer;

/**
 * @author tss2019
 * @version 1.0
 * @date 2019/6/12
 */
public class Test1 {
    /**
     * main test
     */
    public static void main(String[] args) {
        func("abcabcabcj");

    }

    public static void func(String str) {
        char c = str.charAt(0);
        int res = 0;
        for (int i = 1; i < str.length(); i++) {
            res = c ^ str.charAt(i);
        }
        System.out.println((char) res);
    }
}
