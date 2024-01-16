package main.problemAndSolving.nowcoder.HUAWEIod.HJ27查找兄弟单词;
//定义一个单词的“兄弟单词”为：交换该单词字母顺序（注：可以交换任意次），而不添加、删除、修改原有的字母就能生成的单词。
//兄弟单词要求和原来的单词不同。例如： ab 和 ba 是兄弟单词。 ab 和 ab 则不是兄弟单词。
//现在给定你 n 个单词，另外再给你一个单词 x ，让你寻找 x 的兄弟单词里，按字典序排列后的第 k 个单词是什么？
//注意：字典中可能有重复单词。
//
//数据范围：1 \le n \le 1000 \1≤n≤1000 ，输入的字符串长度满足 1 \le len(str) \le 10 \1≤len(str)≤10  ， 1 \le k < n \1≤k<n
//输入描述：
//输入只有一行。 先输入字典中单词的个数n，再输入n个单词作为字典单词。 然后输入一个单词x 最后后输入一个整数k
//输出描述：
//第一行输出查找到x的兄弟单词的个数m 第二行输出查找到的按照字典顺序排序后的第k个兄弟单词，没有符合第k个的话则不用输出。
//示例1
//输入：
//3 abc bca cab abc 1
//复制
//输出：
//2
//bca
//复制
//示例2
//输入：
//6 cab ad abcd cba abc bca abc 1
//复制
//输出：
//3
//bca
//复制
//说明：
//abc的兄弟单词有cab cba bca，所以输出3
//经字典序排列后，变为bca cab cba，所以第1个字典序兄弟单词为bca

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strings = in.nextLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int k = Integer.parseInt(strings[n + 2]);
        String word = strings[n + 1];
        int[] dict = new int[26];
        int[] stat = new int[26];
        int count = 0;
        long[] cache = new long[k];
        for (int i = 0; i < word.length(); i++) {
            dict[word.charAt(i) - 'a']++;
        }
        for (int i = 0; i < cache.length; i++) {
            cache[i] = 0xffff_ffff_ffff_ffffL;
        }
        for (int i = 1; i < n + 1; i++) {
            String s = strings[i];
            //长度和同值过滤
            if (word.length() != s.length() || word.equals(s)) {
                continue;
            }
            //字符及数量过滤
            for (int j = 0; j < 26; j++) {
                stat[i] = dict[i];
            }
            for (int j = 0; j < strings[i].length(); j++) {
                int l = s.charAt(j) - 'a';
                stat[l]--;
                if (stat[l] < 0) {
                    s = "";
                    break;
                }
            }
            if (s.length() == 0) continue;
            //字典序排序
            count++;
            long num = toNum(s);
            int j = 0;
            while (j < cache.length && cache[j] < num) j++;
            if (k - j - 1 >= 0) {
                System.arraycopy(cache, j, cache, j + 1, k - j - 1);
                cache[j] = num;
            }
        }
        System.out.println(count);
        if (count >= k) System.out.println(toStr(cache[k]));

//        for (int i = 0; i < strings.length; i++) {
//            System.out.println(strings[i]);
//        }
//        System.out.println("n = " + n);
//        System.out.println("k = " + k);
    }

    private static long toNum(String s) {
        long ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            ans *= 26;
            ans += c;
        }
        return ans;
    }

    private static String toStr(long n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append((char) ('a' + n % 26));
            n /= 26;
        }
        return sb.reverse().toString();
    }
}