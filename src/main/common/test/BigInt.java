package test;

import java.util.LinkedHashMap;

/**
 * @author tss2019
 * @version 1.0
 * @date 2019/5/25
 */
public class BigInt {
    /**
     * main test
     */
    public static void main(String[] args) {
        String s1 = "10929321231";
        String s2 = "1092441231";
        ArrayTmp tmp = str2IntArr(s1, s2);
        int[] res = bigInArrPlus(tmp.a_arr, tmp.b_arr);
        for (int i = res.length - 1; i >= 0; i--) {
            System.out.print(res[i]);
        }
        System.out.println();
        System.out.println(String.valueOf(10929321231L + 1092441231L));

        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("aa", "aa");
        map.put("ab", "ab");
        map.put("ca", "ca");
        map.remove(map.keySet().iterator().next());
        map.forEach((k, v) -> System.out.println(k + " " + v));
    }

    public static ArrayTmp str2IntArr(String a, String b) {
        int maxLen = a.length() > b.length() ? a.length() : b.length();
        int[] a_arr = new int[maxLen + 1];
        int[] b_arr = new int[maxLen + 1];
        for (int i = 0; i < a.length(); i++) {
            a_arr[i] = Integer.valueOf(String.valueOf(a.charAt(a.length() - 1 - i)));
        }
        for (int i = 0; i < b.length(); i++) {
            b_arr[i] = Integer.valueOf(String.valueOf(b.charAt(b.length() - 1 - i)));
        }
        ArrayTmp tmp = new ArrayTmp(a_arr, b_arr);
        return tmp;
    }

    public static int[] bigInArrPlus(int[] a, int[] b) {
        int len = a.length > b.length ? a.length : b.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int tmp = a[i] + b[i];
            if (tmp >= 10) {
                res[i] += tmp - 10;
                res[i + 1] += 1;
            } else {
                if (res[i] + tmp >= 10) {
                    res[i] += tmp - 10;
                    res[i + 1] += 1;
                } else {
                    res[i] += tmp;
                }
            }
        }
        return res;
    }
}

class ArrayTmp {
    public int[] a_arr;
    public int[] b_arr;

    public ArrayTmp(int[] a_arr, int[] b_arr) {
        this.a_arr = a_arr;
        this.b_arr = b_arr;
    }
}

