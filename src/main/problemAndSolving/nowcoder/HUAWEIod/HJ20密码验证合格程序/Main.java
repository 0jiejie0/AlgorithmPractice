package main.problemAndSolving.nowcoder.HUAWEIod.HJ20密码验证合格程序;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.nextLine();
            //长度
            if (s.length() <= 8) {
                s = "";
            }
            //不少于三种字符
            int kinds = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
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
            kinds = (kinds & 1) + ((kinds >> 1) & 1) + ((kinds >> 2) & 1) + ((kinds >> 3) & 1);
            if (kinds < 3) {
                s = "";
            }
            //无长度大于二的共同子串重复
            Set<Integer> set = new HashSet<>();
            int cur = 0;
            for (int i = 0; i < 3 && i < s.length(); i++) {
                cur <<= 8;
                cur += s.charAt(i);
            }
            set.add(cur);
            for (int i = 3; i < s.length(); i++) {
                cur <<= 8;
                cur &= 0x00ffffff;
                cur += s.charAt(i);
                if (set.contains(cur)) {
                    s = "";
                    break;
                }
                set.add(cur);
            }
            if ("".equals(s)) {
                System.out.println("NG");
            } else {
                System.out.println("OK");
            }
        }
    }
}
