package base;

import java.util.Arrays;

/**
 * @author ZhaoTengchao
 * @description 堆排序
 * 主思路：先利用数组原地进行堆的构建，再根据堆的特性对数组内的数据进行根值后移、堆结构有序化操作
 * 核心：sink方法，即当前元素与它的两个子元素之间的比较及交换
 * 重点：堆结构映射到数组上的存储方式
 * @date 2021/7/6 下午2:50
 **/
public class Heap {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{3,2,5,7,9,4};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(Comparable[] array) {
        int N = array.length;
        // 堆的构建, 先对整个堆中最小的分支块进行堆排序，小的分支排好之后再排大的，相当于从底向上的构建
        // 然后在实际构建的时候(对应于sink方法)，对于当前的小的分支块，又是从上至下的堆有序化，这块需要注意，不要搞不清楚
        for (int k = N / 2; k >= 1; k--) {
            sink(array, k, N);
        }
        int k = N;
        while (k > 1) {
            // 这里的1对应着数组中的0，根据大顶堆的定义，可知索引为0对应的值为当前数组中的最大值
            // 每次循环都将当前的最大值往后放
            exch(array, 1, k--);
            // 最大值后放后，对从1开始(数组中的0)，到k-1内的元素再进行堆的有序化
            sink(array, 1, k);
        }
    }

    /**
     * 由上至下的堆有序化(下沉) - 注意，在方法的处理中，是按照从1开始(而不是从0开始)的思路来进行设计的，
     * 不过，实际情况是 数组却是从索引0开始算的，所以，在具体的exch方法以及less方法在进行到实际对应到数组内元素的时候
     * 需要对传入的索引值减一
     *
     * @param array 待处理的数组
     * @param k 当前处理的节点k
     * @param N 堆内包含的总元素个数
     */
    public static void sink(Comparable[] array, int k, int N) {
        // 在数组中，堆按层级划分之后，当前节点与其子层级节点的关系是：若当前节点为k，那么它的两个子节点将分别是2k,2k+1
        // 首先判断范围为2k是否小于等于N，为什么要等于？因为当前k节点有可能存在只包含一个子节点的情况
        while (2 * k <= N) {
            // 设定左子节点为j
            int j = 2 * k;
            // 若左子节点小于元素个数(极限值就意味着j+1等于元素个数) 并且 左子元素小于右子元素的情况下，证明右侧的元素是两个子元素中最大的那一个
            // 此时将j的值加一，也就是将j的值设置为当前两个子元素中最大的值对应的那个
            if (j < N  && less(array, j, j + 1)) {
                j++;
            }
            // 若父元素的值大于等于了两个子元素中的最大值，则证明当前堆结构已处理完毕，结束循环
            if (!less(array, k, j)) {
                break;
            }
            // 若父元素的值小于两个子元素中的最大值，就将父元素的值与子元素的值进行交换
            exch(array, k, j);
            // 交换完毕后，将当前j的值赋值给k，由于进行的值的交换，有可能导致交换后的值小于自己的子元素，因此需要进行下一循环，检测交换后的值与
            // 子元素的大小
            k = j;
        }
    }

    private static boolean less(Comparable[] array, int i, int j) {
        return array[i - 1].compareTo(array[j - 1]) < 0;
    }

    private static void exch(Comparable[] array, int i, int j) {
        Comparable temp = array[i - 1];
        array[i - 1] = array[j - 1];
        array[j - 1] = temp;
    }
}
