package main.problemAndSolving.nowcoder_20241223.T3进制转换;

import java.util.Scanner;

// 对于给定的十六进制数，输出其对应的十进制表示。
//在本题中，十六进制数的格式为：
//0x
//0x 开头，后跟若干个十六进制数字（
//0-9
//0-9 和
//A-F
//A-F ）。其中，
//A-F
//A-F 依次代表
//10
//−
//15
//10−15 。
//时间限制：C/C++ 1秒，其他语言2秒
//空间限制：C/C++ 32M，其他语言64M
//输入描述：
//\hspace{15pt}在一行上输入一个十六进制数 s ，代表待转换的十六进制数。
//\hspace{15pt}保证 s 转化得到的十进制数 x 的范围为 1 \leqq x \leqq 2^{31}-1 。
//输出描述：
//\hspace{15pt}在一行上输出一个整数，代表 s 对应的十进制数。
//示例1
//输入例子：
//0xFA93
//输出例子：
//64147
//例子说明：
//\hspace{15pt}回忆十六进制转化为十进制的方法：从右往左，将第 i 位乘以 {\color{orange}{16^i}} ，然后求和。
//
//\hspace{15pt}在这个样例中，\texttt{0xFA93} 的第 0 位是 \texttt{3} ，第 1 位是 \texttt{9} ，第 2 位是 \texttt{A} ，第 3 位是 \texttt{F} ，因此 \texttt{0xFA93} = 3 \times {\color{orange}{16^0}} + 9 \times {\color{orange}{16^1}} + 10 \times {\color{orange}{16^2}} + 15 \times {\color{orange}{16^3}} = 64147 。
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] array = scanner.nextLine().toCharArray();
        int ans = 0;
        for (int i = 2; i < array.length; i++) {
            char c = array[i];
            int t = 0;
            if (c >= '0' && c <= '9') {
                t = c - '0';
            } else {
                t = c - 'A' + 10;
            }
            ans <<= 4;
            ans |= t; // 或运算比加法运算应该更快
        }
        System.out.println(ans);
    }
}
