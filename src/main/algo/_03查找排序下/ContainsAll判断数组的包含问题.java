package main.algo._03查找排序下;

import java.util.Arrays;

public class ContainsAll判断数组的包含问题 {
    /**
     * 判断sa的所有字符是否都包含在sb中
     * @param sa
     * @param sb
     * @return
     */
    public static final boolean check(String sa, String sb) {
        char[] chb = sb.toCharArray();
        Arrays.sort(chb);
        for (char c : sa.toCharArray()) {
            if (Arrays.binarySearch(chb, c) < 0) {
                return false;
            }
        }
        return true;
    }
}
