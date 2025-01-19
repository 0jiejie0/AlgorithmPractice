package main.problemAndSolving.nowcoder_20241223.T2明明的随机数;

import java.util.Arrays;
import java.util.Scanner;

// 对于明明生成的
//n
//n 个
//1
//1 到
//500
//500 之间的随机整数，你需要帮助他完成以下任务：
//∙
// 
//∙删去重复的数字，即相同的数字只保留一个，把其余相同的数去掉；
//∙
// 
//∙然后再把这些数从小到大排序，按照排好的顺序输出。
//你只需要输出最终的排序结果。
//时间限制：C/C++ 1秒，其他语言2秒
//空间限制：C/C++ 32M，其他语言64M
//输入描述：
//\hspace{15pt}第一行输入一个整数 n\ (1 \leqq n \leqq 1000)，代表明明生成的数字个数。
//\hspace{15pt}此后 n 行，第 i 行输入一个整数 a_i\ (1 \leqq a_i \leqq 500)，代表明明生成的随机整数。
//输出描述：
//\hspace{15pt}输出若干行，每行输出一个整数，代表输入数据排序后的结果。第一行输出最小的数字。
//示例1
//输入例子：
//3
//2
//2
//1
//输出例子：
//1
//2
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        int j = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[j++] = arr[i];
            }
        }
        for (int i = 0; i < j; i++) {
            System.out.println(arr[i]);
        }
    }
}
