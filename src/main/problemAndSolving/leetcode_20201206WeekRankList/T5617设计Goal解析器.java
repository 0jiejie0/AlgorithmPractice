package main.problemAndSolving.leetcode_20201206WeekRankList;

public class T5617设计Goal解析器 {
    public String interpret(String command) {
        char[] chars = command.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if ('G' == chars[i]) {
                stringBuilder.append('G');
            } else if ('(' == chars[i] && ')' == chars[i + 1]) {
                stringBuilder.append('o');
                i++;
            } else {
                stringBuilder.append("al");
                i += 3;
            }
        }
        return stringBuilder.toString();
    }
}
