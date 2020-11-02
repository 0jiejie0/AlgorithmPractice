package main.algo._01BitOperation;

public class k个数中出现1次的数 {
    public int find(int[] arr, int k) {
        int[] sum = new int[32];
        String[] temp;
        for (int n : arr) {
            temp = Integer.toString(n, k).split("");//注意左边（数组起点）是数值高位
            for (int i = temp.length - 1; i >= 0; i--) {
                sum[temp.length - i - 1] += Integer.valueOf(temp[i], k);//sum数组左边是数值低位(数值地位对数组低下标便于对齐和计算)
                sum[temp.length - i - 1] %= k;
            }
        }
        int res = 0;
        for (int i = sum.length - 1; i >= 0; i--) {
            res *= k;
            res += sum[i];
        }
        return res;
    }
}
