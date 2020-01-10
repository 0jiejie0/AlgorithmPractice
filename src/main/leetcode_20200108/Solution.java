package main.leetcode_20200108;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
 * 解题思路一：40ms38MB
 * 1、将字典字符转化为map对象（需要存储）
 * 2、将数组中的每个单词转化为<字母,字母计数>键值对的map对象（不需要暂存）
 * 3、将每个单词的键值对与字典比较:
 * 1）字母【词】∈字母【字典】且 单字母计数 词<=字典 时，说明该单词掌握，将词中的字母数累加到总和中
 * 2）否则单词没有掌握，不作操作，继续执行
 * 优化一：23ms37.9MB
 * 边界优化（他人题解启发）
 * 1、单词长度大于字典长度，则该单词一定不被掌握
 * 2、单词map中的字符种类数多于字典的字符种类数，则单词一定不被掌握
 * 优化二：19ms38.4MB
 * 路径过程优化
 * 1、单词转换map时即判断 当前字符种类包含在字典中
 * 1、单词转换map时即判断 单词当前字符种类的数量不大于字典的
 * 优化三：
 * 1、转化时将用到的量存入变量，减少嵌套多次调用转化时间
 * 2、string->map转换时计算总acsII码计数，单词一定小于字典
 * （这是上界，但不是上确界，与单词字母数量相关的下界有待确定，上下界的计算应该会消耗一定性能，
 * 算法模型大概描述为在给定的数字序列（可能含有重复数字）中求给定数量的数字最小和与最大和，
 * 模型变种1：已知给定数量的数字中含有若干数字（各异，给定的数字各不相同），从序列中求最小和与最大和
 * 模型变种2：已知给定数量的数字中含有若干数字（给定的数字中可能存在相同数字），从序列中求最小和与最大和）
 * 优化四：
 * 1、将map改为一维数组，长度26
 * 优化五：
 * 1、关于优化三-2的模型，采用计数排序对序列进行排序（在优化四中已经实现），求k个数字的最大最小和时从头或尾部取k个数字即可
 * 2、关于优化三-2的模型变种，从排序后的序列中取出给定数字，然后再找最大最小和即可
 * 计算上下界的性能代价：1*（字典长度-1）^2，初步估计数据量大时效率提高明显
 */
class SpellWord {
    //    原数据
    private String dictString = null;
    private String[] words = null;
    //    字典map
    private Map<Character, Integer> dictMap = null;
    //    字典中的字符种类数
    private int dictCharKinds = 0;
    private int dictCodeValue = 0;

    /**
     * 供外部调用，完成全部逻辑
     *
     * @param words
     * @param chars
     * @return
     */
    public int countCharacters(String[] words, String chars) {
        int result = 0;
//        每次调用时，初始化所有数据
        this.words = words;
        this.dictString = chars;
        this.dictMap = null;
        this.dictCharKinds = 0;
        this.dictCodeValue = 0;
//        字典转化为map
        this.dictMap = convert(chars);
        for (String word : words) {
//            判断每个单词是否包含在字典中，并计数
            result += judgeAndCount(word);
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
     * @return 返回map对象表示单词可能被掌握，返回null表示单词不会被掌握
     */
    private Map<Character, Integer> convert(String word) {
        Map<Character, Integer> map = new HashMap<>();
        int codeValue = 0;
        for (char c : word.toCharArray()) {
//            ascII计数
            codeValue += c;
            if (dictMap != null) {//单词转化为map时（字典转化时dictMap为null）
//                判断ascII上界
                if (codeValue > dictCodeValue) {
                    return null;
                }
//                检查字典 不含该字母或字母个数少于单词 说明该单词不能掌握
                if (!dictMap.containsKey(c) || dictMap.get(c).equals(map.get(c))) {
                    return null;
                }
            }
            countAdd(map, c);
        }
        if (dictMap == null) {
            dictCharKinds = map.keySet().size();
            dictCodeValue = codeValue;
        }
        return map;
    }

    /**
     * 判断一个单词map对象是不是包含在字典中，在字典中返回单词长度，否则返回0代表该单词不能被掌握
     *
     * @param word
     * @return
     */
    private int judgeAndCount(Map<Character, Integer> word) {
        if (word == null || word.size() == 0) {
            return 0;
        }
        Set<Character> set = word.keySet();
        if (set.size() > dictCharKinds) {//边界优化：单词字符类数多于字典，不合条件
            return 0;
        }
        int count = 0;
        for (Character c : set) {
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

    private int judgeAndCount(String word) {
        if (word.length() > dictString.length()) {//边界优化：单词长度大于字典长度，不合条件
            return 0;
        }
        return judgeAndCount(convert(word));
    }
}