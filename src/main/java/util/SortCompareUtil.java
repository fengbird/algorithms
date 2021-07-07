package util;

/**
 * @author ZhaoTengchao
 * @description 排序模版，排序必包含比较和交换，不同的排序算法之间在于在什么时机进行了比较、什么时机进行了交换
 * @since 2021/6/21 下午5:03
 **/
public class SortCompareUtil {
    /**
     * 比较对象v与对象w，若v小于w则为true，若v大于w则为false
     * @param v 待比较值
     * @param w 待比较值
     * @return 比较结果
     */
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 指定数组中的两个索引对应的值进行交换
     * @param a 待进行交换值的数组
     * @param i 待进行值交换索引i
     * @param j 待进行值交互索引j
     */
    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
