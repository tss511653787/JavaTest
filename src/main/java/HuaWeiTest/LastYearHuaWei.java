package HuaWeiTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class LastYearHuaWei {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // StringSplit();
        maxAppear();
    }

    public static void StringSplit() {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(",");
        int num = Integer.valueOf(input[0]);
        int splen = Integer.valueOf(input[1]);
        ArrayList<String> list = new ArrayList<>();
        while (num != 0) {
            String in = scan.nextLine();
            if (in.length() < splen) {
                int insertZero = splen - in.length();
                StringBuilder answer = new StringBuilder();
                answer.append(in);
                for (int i = 0; i < insertZero; i++) {
                    answer.append("0");
                }
                list.add(answer.toString());
            } else if (in.length() > splen) {
                int numS = in.length() / splen;
                int lastlen = in.length() % splen;
                for (int i = 0, j = 0; i < numS; i++) {
                    StringBuilder answer = new StringBuilder();
                    answer.append(in.substring(j, j + splen));
                    list.add(answer.toString());
                    j = j + splen;
                }
                String last = in.substring(numS * splen);
                StringBuilder answer = new StringBuilder();
                answer.append(last);
                for (int i = 0; i < splen - lastlen; i++) {
                    answer.append("0");
                }
                list.add(answer.toString());
            } else {
                // 等于splen情况
                list.add(in);
            }
            num--;

        }
        list.forEach(x -> System.out.println(x));
    }

    public static void maxAppear() {
        Scanner scan = new Scanner(System.in);
        String[] in = scan.nextLine().split(" ");
        TreeMap<String, Integer> treemap = new TreeMap<>();
        for (String s : in) {
            treemap.put(s, treemap.getOrDefault(s, 0) + 1);
        }
        ArrayList<Map.Entry<String, Integer>> answer = new ArrayList<>(
                treemap.entrySet());
        Entry<String, Integer> entryRes = Collections.max(answer,
                new Comparator<Map.Entry<String, Integer>>() {
                    // 降序排列map集合
                    @Override
                    public int compare(Entry<String, Integer> o1,
                                       Entry<String, Integer> o2) {
                        // TODO Auto-generated method stub
                        if (o1.getValue() < o2.getValue()) {
                            return -1;
                        } else if (o1.getValue() == o2.getValue()) {
                            return 0;
                        } else {
                            return 1;

                        }
                    }

                });

        ArrayList<String> finalRes = new ArrayList<>();
        String res = entryRes.getKey();
        finalRes.add(res);
        Set<Entry<String, Integer>> mapSet = treemap.entrySet();
        for (Entry<String, Integer> en : mapSet) {
            if ((en.getKey() != res) && (en.getValue() == entryRes.getValue())) {
                finalRes.add(en.getKey());
            }
        }
        // 升序排列后输出
        Collections.sort(finalRes);
        finalRes.forEach(x -> System.out.print(x + " "));
    }

}
