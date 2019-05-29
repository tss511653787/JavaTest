package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author tss2019
 * @version 1.0
 * @date 2019/5/28
 */
public class RedBag {
    public static void main(String[] args) {
        takeRedBag(100, 10).forEach(System.out::println);
    }

    /**
     * double avg method impl red bag
     */
    public static List<Integer> takeRedBag(int sum, int num) {
        List<Integer> resList = new ArrayList<>();
        int peopleNum = num;
        Random random = new Random();
        for (int i = 0; i < num - 1; i++) {
            int a = random.nextInt(sum / peopleNum * 2 - 2) + 1;
            resList.add(a);
            sum -= a;
            peopleNum--;
        }
        resList.add(sum);
        return resList;
    }
}
