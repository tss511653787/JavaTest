package test;

import java.util.Arrays;

/**
 * @author tss2019
 * @version 1.0
 * @date 2019/5/23
 */
public class XiaoHui {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 4, 3, 5};
//        int [] res =  findNumrest(nums);
    }

    public static int[] findNumrest(int[] nums) {
        int index = findBound(nums);
        int[] numsCopy = Arrays.copyOf(nums, nums.length);
        exchangeNums(numsCopy, index);
        reverse(numsCopy, index);
        return numsCopy;
    }

    private static int[] reverse(int[] numsCopy, int index) {
        for (int i = index, j = numsCopy.length - 1; i < j; i++, j--) {
            int tmp = numsCopy[i];
            numsCopy[i] = numsCopy[j];
            numsCopy[j] = tmp;
        }
        return numsCopy;
    }

    private static void exchangeNums(int[] numsCopy, int index) {
        int head = numsCopy[index - 1];
        for (int i = numsCopy.length - 1; i > 0; i--) {
            if (head < numsCopy[i]) {
                numsCopy[index - 1] = numsCopy[i];
                numsCopy[i] = head;
                break;
            }
        }
    }

    private static int findBound(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                return i;
            }
        }
        return 0;
    }
}
