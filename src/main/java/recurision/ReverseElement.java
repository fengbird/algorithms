package recurision;

import java.util.Arrays;

/**
 * @author ZhaoTengchao
 * @description 给定一个数组及索引范围，将指定范围内的元素进行翻转
 * @since 2021/6/18 下午4:56
 **/
public class ReverseElement {
    public static void main(String[] args) {
        int[] origin = new int[]{1,2,3,4,5};
        reverse(origin, 0, origin.length - 1);
        System.out.println(Arrays.toString(origin));
    }

    /**
     * 减而治之，每次减少一点问题的规模，并得出最终的结果
     */
    public static void reverse(int[] origin, int lo, int hi) {
        // 跳出条件
        if (lo >= hi) {
            return;
        }
        // 每次递归实际要做的事情
        swap(origin, lo, hi);
        // 进入下次递归
        reverse(origin, lo + 1, hi - 1);
    }

    public static void swap(int[] origin, int lo, int hi) {
        int loEle = origin[lo];
        int hiEle = origin[hi];
        origin[lo] = hiEle;
        origin[hi] = loEle;
    }
}
