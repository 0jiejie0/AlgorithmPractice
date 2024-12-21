package main.problemAndSolving.nowcoder_20241220.THJ20密码验证合格程序;

import java.util.Scanner;

// 中等  通过率：30.37%  时间限制：1秒  空间限制：32M
//知识点
//字符串
//数组
//模拟
//warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
//描述
//密码要求:
//
//1.长度超过8位
//
//2.包括：大写字母/小写字母/数字/其它符号，以上四种至少三种
//
//3.不能分割出两个相等的长度大于 2 的子串，例如 abcabc 可以分割出两个 abc，不合法，ababa 则无法分割出2个aba。
//注：其他符号不含空格或换行
//
//数据范围：输入的字符串长度满足
//1
//≤
//n
//≤
//100
//
//1≤n≤100
//输入描述：
//一组字符串。
//
//输出描述：
//如果符合要求输出：OK，否则输出NG
//
//示例1
//输入：
//021Abc9000
//021Abc9Abc1
//021ABC9000
//021$bc9000
//021Abc1111
//复制
//输出：
//OK
//NG
//NG
//OK
//OK
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            m(scanner.nextLine());
        }
    }

    private static void m(String s) {
        if (s.length() <= 8) {
            System.out.println("NG");
            return;
        }
        int kinds = 0;
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (c >= 'A' && c <= 'Z') {
                kinds |= 1;
            } else if (c >= 'a' && c <= 'z') {
                kinds |= 2;
            } else if (c >= '0' && c <= '9') {
                kinds |= 4;
            } else {
                kinds |= 8;
            }
        }
        kinds = (kinds & 0b0101) + ((kinds >> 1) & 0b0101);
        kinds = (kinds & 0b0011) + ((kinds >> 2) & 0b0011);
        if (kinds < 3) {
            System.out.println("NG");
            return;
        }
        for (int i = 0; i < charArray.length - 2; i++) {
            for (int j = i + 3; j < charArray.length - 2; j++) {
                for (int k = 0; k < 3; k++) {
                    if (charArray[i + k] != charArray[j + k]) {
                        kinds = 1;
                        break;
                    } else {
                        kinds = -1;
                    }
                }
                if (kinds < 0) {
                    System.out.println("NG");
                    return;
                }
            }
        }
        System.out.println("OK");
    }
}
