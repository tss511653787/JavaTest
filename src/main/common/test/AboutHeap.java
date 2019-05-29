package test;

/**
 * @author tss2019
 * @version 1.0
 * @date 2019/5/11
 */
public class AboutHeap {
    /**
     * main test
     */
    public static void main(String[] args) {
        int[] nums = {7, 1, 3, 10, 5, 2, 8, 9, 6};
        nums = initailHeap(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
        nums[8] = 0;
        System.out.println();
        upAdjust(nums, 8);
        for (int i : nums) {
            System.out.print(i + " ");
        }
        allSort("12345","");

    }

    private static void allSort(String str, String out) {
        if (0 == str.length()) {
            System.out.println(out);
        } else {
            for (int i = 0; i < str.length(); i++) {
                StringBuilder builder = new StringBuilder(str);
                String c = String.valueOf(builder.charAt(i));
                String sub = builder.deleteCharAt(i).toString();
                allSort(sub, out + c);
            }
        }
    }

    /**
     * 思路:从最后一个非叶子节依次向前做下沉调整
     * 判断最后一个非叶子节点:最后一个叶子的双亲就是 (i-1)/2
     */
    public static int[] initailHeap(int[] nums) {
        int len = nums.length;
        for (int i = (len - 2) / 2; i >= 0; i--) {
            downAdjust(nums, i, len);
        }
        return nums;
    }

    /**
     * downAdjust
     */
    public static void downAdjust(int[] nums, int i, int len) {
        int childIndex = 2 * i + 1;
        while (childIndex < len) {
            if (childIndex + 1 < len && nums[childIndex + 1] > nums[childIndex]) {
                childIndex++;
            }
            if (nums[i] < nums[childIndex]) {
                swap(nums, i, childIndex);
            }
            i = childIndex;
            childIndex = 2 * i + 1;
        }
    }

    /**
     * Up adjust
     */
    public static void upAdjust(int[] nums, int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (nums[index] < nums[parent]) {
                swap(nums, index, parent);
            }
            index = parent;
        }
    }


    public static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
