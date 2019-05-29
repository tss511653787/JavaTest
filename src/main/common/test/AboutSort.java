package test;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author tss2019
 * @version 1.0
 * @date 2019/5/15
 */
public class AboutSort {
    public static void main(String[] args) {
        int[] nums = {-1, 10, -15, 6, 99, 32, 16, 27, 18};
        bluckSort(nums, 10);
    }

    /**
     * maopaoB
     */
    public static void maoPaoB(int[] nums) {
        int outBound = nums.length - 1;
        for (int i = 0; i < nums.length - 1; i++) {
            int bound = outBound;
            boolean flag = true;
            for (int j = 0; j < bound; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    flag = false;
                    outBound = j;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    /**
     * 优化计数排序
     */
    public static void jiShuOptimise(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num1 : nums) {
            if (num1 < min) {
                min = num1;
            }
            if (num1 > max) {
                max = num1;
            }
        }
        int[] countArray = new int[max - min + 1];
        int[] sortedArray = new int[nums.length];
        for (int num : nums) {
            countArray[num - min]++;
        }
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }
        for (int j = nums.length - 1; j >= 0; j--) {
            sortedArray[countArray[nums[j] - min] - 1] = nums[j];
            countArray[nums[j] - min]--;
        }
        System.arraycopy(sortedArray, 0, nums, 0, nums.length);
    }

    public static void bluckSort(int[] nums, int bluckNum) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num1 : nums) {
            if (num1 < min) {
                min = num1;
            }
            if (num1 > max) {
                max = num1;
            }
        }
        List<ArrayList<Integer>> blucks = new ArrayList<>(bluckNum);
        for (int i = 0; i < bluckNum; i++) {
            blucks.add(new ArrayList<>());
        }
        int d = max - min;
        for (int n : nums) {
            int num = ((n - min) * (bluckNum - 1) / d);
            blucks.get(num).add(n);
        }
        blucks.forEach(Collections::sort);
        blucks.forEach(l -> l.forEach(n -> System.out.print(n + " ")));
    }

    private static void swap(int[] nums, int j, int i) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
}
