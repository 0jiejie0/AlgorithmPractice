package main.algo._01BitOperation;

public class 交换奇偶位 {
    public static final int swap(int ori) {
        int even = ori & 0xaaaaaaaa;//偶数位
        int odd = ori & 0x55555555;//奇数位
        return (even >>> 1) | (odd << 1);//注意负数的符号位，用无符号位移
    }
}
