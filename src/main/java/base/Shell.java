package base;

import util.SortCompareUtil;

import java.util.Arrays;

/**
 * @author ZhaoTengchao
 * @description 希尔排序-插入排序的改进，解决插入由于经常移动元素不适用于大数据的缺陷，当数据量不大时，相比插入排序并没有太大的优势
 * 如果需要解决一个排序问题而又没有系统排序函数可用，可以先用希尔排序
 * @since 2021/6/25 下午3:04
 **/
public class Shell {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{4,5,6,2,3,9,0,1};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(Comparable[] array) {
        int N = array.length;
        int h = 1;
        // N/3 为经验数据，没有具体的得出方式
        while (h < N/3) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            // 这里就是插入排序了，按照间隔h先对数组局部排序一下，减少当为大规模数组的时候元素频繁移动的问题
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && SortCompareUtil.less(array[j], array[j - h]); j -= h) {
                    SortCompareUtil.exch(array, j, j - h);
                }
            }
            // 每次将h等比例缩小三倍，与上面h的设置呼应，保证最后一次循环h = 1，h = 0的时候退出循环
            h = h/3;
        }
    }
}
