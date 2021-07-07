package traverse;

/**
 * @author ZhaoTengchao
 * @description 给定一个数组，以及索引范围，找出在这个范围内的最大值和次最大值
 * 个人感悟：数组索引的赋值可以在中括号内进行
 * @since 2021/6/19 下午4:38
 **/
public class Max2 {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6};
        max2(array, 0, 6);
    }

    public static void max2(int[] array, int lo, int hi) {
        int x1;
        int x2;
        Result result;
        // 对首位的两个元素进行特殊的处理，由于会指定lo元素的值，故无需再做多余的初始位置的判断
        if (array[x1 = lo] < array[x2 = lo + 1]) {
            result = swap(x1, x2);
            x1 = result.x1;
            x2 = result.x2;
        }

        // 由于前两个值的最大值和最小值已经判断出来，所以遍历时从第三个值开始
        for (int i = lo + 2; i < hi; i++) {
            // 若x2所在的值比当前所在索引对应的值小，那么才会进行下面的判断，否则维持x2的值
            if (array[x2] < array[i]) {
                // 此处高能！！！！！
                // 这一步有两个处理，首先是将当前i的值赋值给了x2，
                // 其次是再对当前的x2的值与x1的值进行比较，若x1的值小于x2，才会进行值的交换
                if (array[x1] < array[x2 = i]) {
                    result = swap(x1, x2);
                    x1 = result.x1;
                    x2 = result.x2;
                }
            }
        }
        printlnArrayX1AndX2(array[x1], array[x2]);
    }

    private static Result swap(int x1, int x2) {
        Result result = new Result();
        x1 = x1 ^ x2;
        x2 = x1 ^ x2;
        x1 = x1 ^ x2;
        result.x1 = x1;
        result.x2 = x2;
        return result;
    }

    private static void printlnArrayX1AndX2(int arrayX1, int arrayX2) {
        System.out.println("arrayX1 = " + arrayX1);
        System.out.println("arrayX2 = " + arrayX2);
    }
    public static class Result {
        private int x1;
        private int x2;
    }
}
