package base;

import util.SortCompareUtil;

import java.util.Arrays;

/**
 * @author ZhaoTengchao
 * @description 插入排序：核心是从左往右遍历，从第二个元素开始与左侧元素进行遍历比较，若当前值小于上一个值，则立马做交换
 * 插入排序：主要也是两层循环，外循环用来控制游标，内循环负责遍历，比较与交换的元素均为内循环当前元素与上一元素
 * @since 2021/6/21 下午5:37
 **/
public class Insertion {
    public static void main(String[] args) {
        String[] a = new String[]{"x","y","z","a","b"};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && SortCompareUtil.less(a[j], a[j - 1]); j--) {
                SortCompareUtil.exch(a, j, j - 1);
            }
        }
    }
}
