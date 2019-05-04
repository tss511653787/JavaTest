package Solution6;

import java.util.TreeSet;

/**
 * Created by tzy on 2017/8/8.
 */
public class Main {
    public static void main(String[] args) {
        String a = "BDCABA";
        String b = "ABCBDAB";

        System.out.println(MyLCS.length_LCS(a,b));

        TreeSet<String> set=MyLCS.sequence_LCS(a,b);
        for(String s : set) {
            System.out.println(s);
        }
    }
}
