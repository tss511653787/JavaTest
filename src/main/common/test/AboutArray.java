package test;

/**
 * @author tss2019
 * @version 1.0
 * @date 2019/5/8
 */
public class AboutArray {
    /**
     * main test
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 0, 0, 0, 0};
        deleteInArray(nums, 2);
        outP(nums);


    }

    /**
     * output
     */
    public static void outP(int[] array) {
        for (int a : array) {
            System.out.print(a + " ");
        }
    }

    /**
     * 一维数组的插入
     */
    public static void insertinArray(int[] nums, int index, int target) {
        int len = nums.length;
        if (index < 0 || index >= nums.length) {
            throw new ArrayIndexOutOfBoundsException("Out of bound.");
        }
        int k = len - 1;
        while (k > index) {
            nums[k] = nums[k - 1];
            k--;
        }
        nums[index] = target;
    }

    /**
     * 数组的删除
     * 直接迁移一个单位然后把最后一个数赋值-1(表示删除)
     */
    public static void deleteInArray(int[] nums, int index) {
        int len = nums.length;
        if (index < 0 || index >= nums.length) {
            throw new ArrayIndexOutOfBoundsException("Out of bound.");
        }
        int k = index;
        while (k < len - 1) {
            nums[k] = nums[k + 1];
            k++;
        }
        nums[k] = -1;
    }
}
