package recurision;

/**
 * @author ZhaoTengchao
 * @description 给定一个数组及索引范围，对范围内的数据进行求和
 * @since 2021/6/18 下午5:25
 **/
public class SumElement {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7};
        System.out.println(sum(array, 0, 3));
    }

    /**
     * 分而治之 将问题拆分得到结果之后再进行结果的汇总
     */
    public static int sum(int[] array, int lo, int hi) {
        // 跳出条件，只考虑本次递归需要做什么事情即可，无需考虑两次递归之间的关系和结果
        if (lo == hi) {
            return array[lo];
        }
        // 递归体
        int mid = (lo + hi) >> 1;
        // 将递归出的结果进行汇总
        return sum(array, lo, mid) + sum(array, mid + 1, hi);
    }
}
