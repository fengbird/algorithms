package base;

import java.util.Arrays;

/**
 * @author ZhaoTengchao
 * @description 快排之三向切分
 * @date 2021/7/5 下午8:01
 **/
public class Quick3way {
    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,6,9,8};
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void sort(int[] nums, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int lt = lo;
        int gt = hi;
        int i = lo + 1;
        int value = nums[lo];
        while (i <= gt) {
            if (compare(nums[i], value) < 0) {
                exch(nums, lt++, i++);
            } else if (compare(nums[i], value) > 0) {
                exch(nums, i, gt--);
            } else {
                i++;
            }
        }
        sort(nums, lo, lt - 1);
        sort(nums, gt + 1, hi);
    }

    private static int compare(int a, int b) {
        return a - b;
    }

    private static void exch(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
