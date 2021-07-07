package base;

import util.SortCompareUtil;

import java.util.Arrays;

/**
 * @author ZhaoTengchao
 * @description 归并排序-自底向上排序-主要思想：将数组每次分成固定的多个区间段，然后分别再对区间段内的数据进行归并排序，最终得到最后的结果
 * 归并(自底向上)排序：自底向上分区段依次进行数据的合并
 * 1. 外层for循环从最小值开始指定每次区段的划分
 * 2. 内层for循环设定起始合并的索引值并进行合并操作
 * @date 2021/7/1 下午4:46
 **/
public class MergeBU {
    private static Comparable[] temp;
    public static void main(String[] args) {
        Integer[] array = new Integer[]{1,9,4,3,2,5};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(Comparable[] array) {
        int length = array.length;
        temp = new Comparable[length];
        // 双层for循环，总的来说是外部for循环进行归并区段的划分，内部for循环进行区段内具体的归并操作

        // 子数组大小，每次需要归并的元素 = 子数组大小 x 2，因为每次循环中最终的目的是要对两个数组进行归并的，若设定子数组大小为1，那么就说明本次要对两个大小为1的数组进行归并
        // 子数组的大小只是一个定义，并不是真的有额外的这么一个数组，实际上都是对原数组在指定某一段索引区间内的归并，每次归并的索引区间段 = 子数组大小 x 2
        for (int childSize = 1; childSize < length; childSize = childSize + childSize) {
            // 在指定子数组大小后，相当于对本次遍历做了一次分段处理，childSize = 1 就是将本次遍历按照区间段为2进行了分段处理，内循环就是需要完成对每个分段的归并操作
            // childIndex 是为了指定每次区间段归并排序时的起始索引值，但是由于到了拆分的后期，无法再等分拆分最后的区段，为了保证最后块数据也可正确的参与合并，因此第二个判断条件：childIndex < length - childSize 就不难理解了
            for (int childIndex = 0; childIndex < length - childSize; childIndex += childSize + childSize) {
                // 由于每次归并的索引区间段 = 子数组大小 x 2 ，因此中值设置为 childIndex + childSize - 1 也就不难理解了
                merge(array, childIndex, childIndex + childSize - 1, Math.min(childIndex + childSize + childSize -1, length - 1));
            }
        }
    }

    public static void merge(Comparable[] array, int lo, int mid, int hi) {
        // 将array[lo..mid] 和 array[mid + 1..hi]归并
        int left = lo;
        int right = mid + 1;
        // 将待归并的数组内的数据复制到缓存数组中
        for (int k = lo; k <= hi; k++) {
            temp[k] = array[k];
        }
        // 从 lo..hi 对其中的所有的索引值依次遍历
        for (int k = lo; k <= hi; k++) {
            // 若数组中值左边的元素用尽，取右边的元素
            if (left > mid) {
                array[k] = temp[right++];
            // 若数组中值右边的元素用尽，取左边的元素
            } else if (right > hi) {
                array[k] = temp[left++];
            // 若右半边的当前元素小于左半边的当前元素，取右半边的元素
            } else if (SortCompareUtil.less(temp[right], temp[left])) {
                array[k] = temp[right++];
            } else {
                // 否则(右半边的元素大于等于左半边的当前元素)，取左半边的元素
                array[k] = temp[left++];
            }
        }
    }
}
