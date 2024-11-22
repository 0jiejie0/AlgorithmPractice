package main.leetcode.editor.cn;

//给定两个字符串 s 和 t ，判断它们是否是同构的。
//
// 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。 
//
// 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。 
//
// 
//
// 示例 1: 
//
// 
//输入：s = "egg", t = "add"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "foo", t = "bar"
//输出：false 
//
// 示例 3： 
//
// 
//输入：s = "paper", t = "title"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// t.length == s.length 
// s 和 t 由任意有效的 ASCII 字符组成 
// 
//
// Related Topics 哈希表 字符串 👍 744 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> mapS = new HashMap<>();
        HashMap<Character, Character> mapT = new HashMap<>();
        char[] arrayS = s.toCharArray();
        char[] arrayT = t.toCharArray();
        for (int i = 0; i < arrayT.length; i++) {
            Character cS = arrayS[i];
            Character cT = arrayT[i];
            if (mapS.containsKey(cS) || mapT.containsKey(cT)) {
                if (!cT.equals(mapS.get(cS)) || !cS.equals(mapT.get(cT))) {
                    return false;
                }
            } else {
                mapS.put(cS, cT);
                mapT.put(cT, cS);
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

// 	执行耗时:18 ms,击败了49.97% 的Java用户
//	内存消耗:41.3 MB,击败了89.95% 的Java用户


// 	执行耗时:13 ms,击败了65.41% 的Java用户
//	内存消耗:41.4 MB,击败了61.24% 的Java用户

// 	执行耗时:10 ms,击败了84.41% 的Java用户
//	内存消耗:41.6 MB,击败了25.31% 的Java用户
//  ???空间和时间当真不可兼得？但是charAt似乎也不多占用多少时间啊，就多了两个条件判定而已