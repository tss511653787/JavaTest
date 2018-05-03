package AiQiyi;

import java.util.Scanner;

public class SSR {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] in = scanner.nextLine().split("\\s+");
        long n = Long.parseLong(in[0]);
        long m = Long.parseLong(in[1]);
        long count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (PanDuan(i, j))
                    count++;
            }
        }
        System.out.print(count);


    }

    public static boolean isIntNum(double n) {
        return n % 1 == 0 ? true : false;
    }

    public static boolean PanDuan(long a, long b) {
        if (isIntNum(Math.sqrt(a)) && isIntNum(Math.sqrt(b))) {
            return true;
        } else if (a == b || func(a, b)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean func(long a, long b) {
        // TODO Auto-generated method stub
        double as = Math.sqrt(a);
        double bs = Math.sqrt(b);
        double c = bs / as;
        double d = as / bs;
        if (isIntNum(c) || isIntNum(d)) {
            return true;
        } else {
            return false;
        }
    }
}
