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
 * 解题思路一：
 * 1、将字典字符转化为map对象（需要存储）
 * 2、将数组中的每个单词转化为<字母,字母计数>键值对的map对象（不需要暂存）
 * 3、将每个单词的键值对与字典比较:
 * 1）字母【词】∈字母【字典】且 单字母计数 词<=字典 时，说明该单词掌握，将词中的字母数累加到总和中
 * 2）否则单词没有掌握，不作操作，继续执行
 */
class SpellWord {
    //    字典map
    private Map<Character, Integer> dictMap = null;

    /**
     * 供外部调用，完成全部逻辑
     *
     * @param words
     * @param chars
     * @return
     */
    public int countCharacters(String[] words, String chars) {
//        每次调用时，初始化所有数据
        dictMap = new HashMap<>();
        int result = 0;
//        字典转化为map
        dictMap = convert(chars);
        for (String word : words) {
//            判断每个单词是否包含在字典中，并计数
            result += judgeMapAndCount(convert(word));
        }
        return result;
    }

    /**
     * 将字母添加到map中
     *
     * @param map
     * @param character
     */
    private void countAdd(Map<Character, Integer> map, Character character) {
        Integer integer = 1;//字母数默认加一
        if (map.containsKey(character)) {//map中已有该字母，数量累加
            integer = integer + map.get(character);
        }
        map.put(character, integer);
    }

    /**
     * 将一个单词转化为一个map对象，包含单词中所有字母及相应个数
     *
     * @param word
     * @return
     */
    private Map<Character, Integer> convert(String word) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = word.toCharArray();
        for (char c : word.toCharArray()) {
            countAdd(map, c);
        }
        return map;
    }

    /**
     * 判断一个单词map对象是不是包含在字典中，在字典中返回单词长度，否则返回0
     *
     * @param word
     * @return
     */
    private int judgeMapAndCount(Map<Character, Integer> word) {
        int count = 0;
        for (Character c :
                word.keySet()) {
            int n = word.get(c);
//            字母【词】∈字母【字典】且 单字母计数 词<=字典
            if (dictMap.containsKey(c) && dictMap.get(c) >= n) {
                count += n;
            } else {
                return 0;
            }
        }
        return count;
    }
}