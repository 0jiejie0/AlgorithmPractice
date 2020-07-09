package main.algo._01BitOperation;

/**
 * 在长度为N+1的数组中有从1-N的N个数字，要求不用辅助空间，一遍访问找到这个数
 */
public class 唯一成对数 {
    /**
     * 运用辅助空间进行计数，计次为2的数即为所求(假设没有不用辅助空间的要求)
     *
     * @param arr
     * @return
     */
    public static final int auxiliarySpace(int[] arr) {
        int[] count = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        int result = 1;
        for (int i = 1; i < count.length; i++) {
            if (count[i] == 2) {
                result = i;
                break;
            }
        }
        return result;
    }

    /**
     * 位运算寻找，利用异或运算a^b^b<==>a的特点
     *
     * @param arr
     * @return
     */
    public static final int bitOp(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res ^= i ^ arr[i];
        }
        return res;
    }
}
