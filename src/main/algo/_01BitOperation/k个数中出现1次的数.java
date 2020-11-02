package main.algo._01BitOperation;

public class k个数中出现1次的数 {
    /**
     * 找出k个数中进出现1次的数
     * 利用k个相同的k进制数 对每一位作不进位加法 得0，
     * 将所有数字转成k进制数，
     * 对每一位累加求和后对k取模
     * 最后将各个位上的数 乘k加和，还原得10进制数
     *
     * @param arr
     * @param k
     * @return
     */
    public int find(int[] arr, int k) {
        int[] sum = new int[32];
        String[] temp;
        for (int n : arr) {//转k进制并求和取模
            temp = Integer.toString(n, k).split("");//注意左边（数组起点）是数值高位
            for (int i = temp.length - 1; i >= 0; i--) {
                sum[temp.length - i - 1] += Integer.valueOf(temp[i], k);//sum数组左边是数值低位(数值地位对数组低下标便于对齐和计算)
                sum[temp.length - i - 1] %= k;
            }
        }
        int res = 0;
        for (int i = sum.length - 1; i >= 0; i--) {//还原数字
            res *= k;
            res += sum[i];
        }
        return res;
    }
}
