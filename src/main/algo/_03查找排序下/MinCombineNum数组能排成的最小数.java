package main.algo._03查找排序下;

import java.util.Arrays;
import java.util.Comparator;

public class MinCombineNum数组能排成的最小数 {
    public int findMinNum(Integer[] arr) {
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String sa = o1 + "" + o2;
                String sb = o2 + "" + o1;
                return sa.compareTo(sb);
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer n :
                arr) {
            stringBuilder.append(n);
        }
        return Integer.parseInt(stringBuilder.toString());
    }
}
