package base;

import util.SortCompareUtil;
import util.StdRandom;

import java.util.Arrays;

/**
 * @author ZhaoTengchao
 * @description 快速排序 - 将数组按照指定值左侧数据小于指定值，指定值右侧数据大于指定值的方式进行递归排序
 * 快速排序：先切分，根据切分点再分别排序(切分递归)
 * 1. 切分时无限循环遍历
 * 2. 暂定中间值
 * 3. 从左到右、从右到左分别设置扫描指针与中间值比较
 * 4. 将中间值与最终右侧索引对应值交换，返回索引
 * @date 2021/7/2 下午4:16
 **/
public class Quick {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{4,3,2,5,6,7,1,9,8};
        StdRandom.shuffle(array);
        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(Comparable[] array, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = partition(array, lo, hi);
        sort(array, lo, mid - 1);
        sort(array, mid + 1, hi);
    }

    public static int partition(Comparable[] array, int lo, int hi) {
        Comparable value = array[lo];
        int i = lo;
        int j = hi + 1;
        while (true) {
            // 从左往右的索引遍历时，若左侧的值比value小，则直接进行下次遍历，直到 i == hi
            while (SortCompareUtil.less(array[++i], value)) {
                if (i == hi) {
                    break;
                }
            }
            // 从右往左的索引遍历时，若右侧的值比value大，则直接进行下次遍历，直到 j = lo
            while (SortCompareUtil.less(value, array[--j])) {
                if (j == lo) {
                    break;
                }
            }
            // 如果i的值大于等于了j的值，证明左右两边的元素均已遍历，跳出循环
            if (i >= j) {
                break;
            }
            // 如果从左往右/从右往左遍历时，未满足上述的条件，则对左右的元素进行交换处理
            SortCompareUtil.exch(array, i, j);
        }
        // 内部遍历完毕后将临界值与最终指针指向的索引进行交换，即可保证指针左侧的元素一定小于当前值，指针右侧的元素一定大于当前值
        SortCompareUtil.exch(array, lo, j);
        System.out.println("i: " + i + ", j: " + j);
        return j;
    }
}
