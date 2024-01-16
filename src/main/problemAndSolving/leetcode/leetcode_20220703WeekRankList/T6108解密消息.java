package main.problemAndSolving.leetcode.leetcode_20220703WeekRankList;

//给你字符串 key 和 message ，分别表示一个加密密钥和一段加密消息。解密 message 的步骤如下：
//
//使用 key 中 26 个英文小写字母第一次出现的顺序作为替换表中的字母 顺序 。
//将替换表与普通英文字母表对齐，形成对照表。
//按照对照表 替换 message 中的每个字母。
//空格 ' ' 保持不变。
//例如，key = "happy boy"（实际的加密密钥会包含字母表中每个字母 至少一次），据此，可以得到部分对照表（'h' -> 'a'、'a' -> 'b'、'p' -> 'c'、'y' -> 'd'、'b' -> 'e'、'o' -> 'f'）。
//返回解密后的消息。
//
//
//
//示例 1：
//
//
//
//输入：key = "the quick brown fox jumps over the lazy dog", message = "vkbs bs t suepuv"
//输出："this is a secret"
//解释：对照表如上图所示。
//提取 "the quick brown fox jumps over the lazy dog" 中每个字母的首次出现可以得到替换表。
//示例 2：
//
//
//
//输入：key = "eljuxhpwnyrdgtqkviszcfmabo", message = "zwx hnfx lqantp mnoeius ycgk vcnjrdb"
//输出："the five boxing wizards jump quickly"
//解释：对照表如上图所示。
//提取 "eljuxhpwnyrdgtqkviszcfmabo" 中每个字母的首次出现可以得到替换表。
//
//
//提示：
//
//26 <= key.length <= 2000
//key 由小写英文字母及 ' ' 组成
//key 包含英文字母表中每个字符（'a' 到 'z'）至少一次
//1 <= message.length <= 2000
//message 由小写英文字母和 ' ' 组成
public class T6108解密消息 {
    public String decodeMessage(String key, String message) {
        char[] cache = new char[26];
        char[] keyChart = key.toCharArray();
        char[] msg = message.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : keyChart) {
            if (c == ' ') {
                continue;
            }
            for (int i = 0; i < 26; i++) {
                if (cache[i] == c) {
                    break;
                } else if (cache[i] == 0) {
                    cache[i] = c;
                    break;
                }
            }
        }
        for (char c : msg) {
            if (c == ' ') {
                stringBuilder.append(' ');
                continue;
            }
            for (int i = 0; i < 26; i++) {
                if (cache[i] == c) {
                    stringBuilder.append((char) (i + 'a'));
                }
            }
        }
        return stringBuilder.toString();
    }
}
