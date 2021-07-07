package base;

import util.SortCompareUtil;

import java.util.Arrays;

/**
 * @author ZhaoTengchao
 * @description 选择排序：核心是从左往右遍历，从第一个数开始，往右依次和[剩余所有元素]进行比较，选出最小值后与当前位置做交换
 * 在一次遍历中先标记，遍历结束后再交换
 * 选择排序：主要做法是用两次循环从左往右，内循环的元素依次与外循环元素比较，然后交换元素
 * @since 2021/6/21 下午5:02
 **/
public class Selection {
    public static void main(String[] args) {
        String[] a = new String[]{"x","y","z","a","b"};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (SortCompareUtil.less(a[j], a[min])) {
                    min = j;
                }
            }
            SortCompareUtil.exch(a, i, min);
        }
    }
}
