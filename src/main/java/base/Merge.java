package base;

import util.SortCompareUtil;

import java.util.Arrays;

/**
 * @author ZhaoTengchao
 * @description 归并排序-递归的方式-自顶向下归并 主要思路：每次将数组进行左右划分，然后进行数据的归并，之后将此过程进行递归调用
 * 归并(递归)排序：先拆分(递归)后合并，拆分时按照索引中值拆分，合并时额外引入缓存数组在元素复制后做合并操作
 * @date 2021/6/30 上午11:17
 **/
public class Merge {
    private static Comparable[] aux;
    public static void main(String[] args) {
        Integer[] array = new Integer[]{1,9,4,3,2,5};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        // 将a[lo..mid] 和 a[mid + 1..hi]归并
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (SortCompareUtil.less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }
}
