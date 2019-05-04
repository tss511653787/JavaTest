package common;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode简单刷题
 * 4.8
 */
public class LeetCode1 {
    //test main
    public static void main(String[] args) {
        wc("abc abc a a c c dc dc j oo oo");
    }

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     */

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    res[0] = i;
                    res[1] = j;
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 16、8、2进制数组相互转换可以使用Integer中现有方法过度
     */
    public static void wc(String str) {
        String[] strs = str.split("\\s+");
        Map<String, Integer> map = new HashMap<>();
        for (String s : strs) {
            if (null != map.putIfAbsent(s, 1)) {
                map.put(s, map.get(s) + 1);
            }
        }
        map.forEach((k, v) -> System.out.println(k + " " + v));
    }

}
