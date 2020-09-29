package main.problemAndSolving.Leetcode_20200920WeekRankList;

//给你一个字符串 text ，该字符串由若干被空格包围的单词组成。每个单词由一个或者多个小写英文字母组成，并且两个单词之间至少存在一个空格。题目测试用例保证 text 至少包含一个单词 。
//
//请你重新排列空格，使每对相邻单词之间的空格数目都 相等 ，并尽可能 最大化 该数目。如果不能重新平均分配所有空格，请 将多余的空格放置在字符串末尾 ，这也意味着返回的字符串应当与原 text 字符串的长度相等。
//
//返回 重新排列空格后的字符串 。
//
//
//
//示例 1：
//
//输入：text = "  this   is  a sentence "
//输出："this   is   a   sentence"
//解释：总共有 9 个空格和 4 个单词。可以将 9 个空格平均分配到相邻单词之间，相邻单词间空格数为：9 / (4-1) = 3 个。
//示例 2：
//
//输入：text = " practice   makes   perfect"
//输出："practice   makes   perfect "
//解释：总共有 7 个空格和 3 个单词。7 / (3-1) = 3 个空格加上 1 个多余的空格。多余的空格需要放在字符串的末尾。
//示例 3：
//
//输入：text = "hello   world"
//输出："hello   world"
//示例 4：
//
//输入：text = "  walks  udp package   into  bar a"
//输出："walks  udp  package  into  bar  a "
//示例 5：
//
//输入：text = "a"
//输出："a"
//
//
//提示：
//
//1 <= text.length <= 100
//text 由小写英文字母和 ' ' 组成
//text 中至少包含一个单词
public class T5519重新排列单词间的空格 {
    public String reorderSpaces(String text) {
        StringBuilder res = new StringBuilder();
        char[] chars = text.toCharArray();
        int len = text.length();
        int spaces = 0, words = 0;
        char last = ' ';
        for (int i = 0; i < len; i++) {//统计单词、空格数量
            if (chars[i] == ' ') {
                spaces++;
                last = ' ';
            } else if (last == ' ') {//首字母计数
                words++;
                last = 0;//非空格
            }
        }
        int spaceStart = 0, spaceEnd = 0;//一个代表空格开始的地方，一个代表单词开始的地方
        int perSpace = words < 2 ? 0 : (spaces / (words - 1));
        last = ' ';
        StringBuilder spaceString = new StringBuilder();
        for (int i = 0; i < perSpace; i++) {
            spaceString.append(' ');
        }

        for (int i = 0; i < len; i++) {
            if (chars[i] == ' ' && last != ' ') {//空格开始
                last = ' ';
                spaceStart = i;
                //拼接单词
                res.append(text, spaceEnd, spaceStart);
            } else if (chars[i] != ' ' && last == ' ') {//单词开始
                last = 0;//非空格
                spaceEnd = i;
                //拼接空格
                if (spaceStart != 0)
                    res.append(spaceString);
            }
        }
        //补足末尾单词
        if (last != ' ') {
            res.append(text, spaceEnd, len);
        }
        //补足空格
        len -= res.length();
        for (int i = 0; i < (len); i++) {
            res.append(' ');
        }
        return res.toString();
    }

//    public String reorderSpaces(String text) {
//        StringBuilder res = new StringBuilder();
//        char[] chars = text.toCharArray();
//        int len = text.length();
//        int l = 0, r = len - 1;
//        while (l < r) {//模仿快排，将空格和字母分开
//            while (chars[l] != ' ') {
//                l++;
//            }
//            while (chars[r] == ' ') {
//                r--;
//            }
//            chars[l] ^= chars[r];
//            chars[r] ^= chars[l];
//            chars[l] ^= chars[r];
//        }
//        r = (len - l) / (l - 1);//此后l为字母数量，r为两字母间空格数
//        StringBuilder spaces = new StringBuilder();//空格
//        for (int i = 0; i < r; i++) {
//            spaces.append(' ');
//        }
//        for (int i = 0; i < l; i++) {//拼接字母部分（最后可能多余一个空格）
//            res.append(chars[i]).append(spaces);
//        }
//        r = len - res.length();//需补足的空格数量
//        for (int i = 0; i < r; i++) {
//            res.append(' ');
//        }
//        if (r < 0) {//除多余空格
//            res.deleteCharAt(len);
//        }
//        return res.toString();
//    }
}
