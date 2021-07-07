package base;

import java.util.Arrays;

/**
 * @author ZhaoTengchao
 * @description 快排之三向切分
 * 递归体[筛出重复值，选定中值，迭代比较并根据比较结果分别将当前值与左/右元素依次交换]
 * 脑内有指针移动图，并且明确具体指针的作用是关键
 * @date 2021/7/5 下午8:01
 **/
public class Quick3way {
    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,8,6,9,8};
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void sort(int[] nums, int lo, int hi) {
        // 临界条件判断
        if (hi <= lo) {
            return;
        }
        // 小于中值区块指针初始化
        int lt = lo;
        // 大于中值区块指针初始化
        int gt = hi;
        // 遍历指针初始化
        int i = lo + 1;
        // 中值初始化
        int value = nums[lo];
        // 设定遍历指针移动范围
        while (i <= gt) {
            // 比较遍历所在值与中值的大小，若小于中值，则将当前值与小于中值指针所在值交换，同时将小于中值指针往右移动一位
            if (compare(nums[i], value) < 0) {
                // 这里为什么要进行i++呢？因为lt进行了加1，而i是比lt大1的，若是i不进行加1，那么下次在进行比较的时候会多出一次相同元素的比较
                exch(nums, lt++, i++);
            // 比较遍历所在值与中值的大小，若大于中值，则将当前值与大于中值指针所在值交换，同时将大于中值指针往左移动一位
            } else if (compare(nums[i], value) > 0) {
                // 这里的i没有加1，因为gt的变化不会导致相同的元素多比较一次的情况出现
                exch(nums, i, gt--);
            // 否则证明遍历所在值与中值相等，遍历指针后移
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
