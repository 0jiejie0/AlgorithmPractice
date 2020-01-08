package main.leetcode_20200108;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int countCharacters(String[] words, String chars) {
        return new SpellWord().countCharacters(words, chars);
    }
}

/**
 * 1160.拼写单词
 * <p>
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 * 注意：每次拼写时，chars 中的每个字母都只能用一次。
 * <p>
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 解题思路：
 * 1、将数组中的每个单词转化为<字母,字母计数>键值对的map对象
 * 2、将所有单词对应的各个map对象组成一个list列表
 * 3、将字典字符转化为map对象
 *
 */
class SpellWord {
    private Map<Character, Integer> wordChars = new HashMap<>();


    public int countCharacters(String[] words, String chars) {
        int result = 0;
        return result;
    }
}