package main.leetcode.editor.cn;//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 4388 👎 0


import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        if (s.length() < 2) return false;
        LinkedList<Character> stackList = new LinkedList<>();
        Character character;
        for (int i = 0; i < s.length(); i++) {
            switch (character = s.charAt(i)) {
                case ')':
                    if (stackList.isEmpty() || !stackList.pop().equals('(')) {
                        return false;
                    }
                    break;
                case ']':
                    if (stackList.isEmpty() || !stackList.pop().equals('[')) {
                        return false;
                    }
                    break;
                case '}':
                    if (stackList.isEmpty() || !stackList.pop().equals('{')) {
                        return false;
                    }
                    break;
                default:
                    stackList.push(character);
                    break;
            }
        }
        return stackList.isEmpty();
        //	执行耗时:1 ms,击败了98.54% 的Java用户
        //	内存消耗:40.4 MB,击败了80.28% 的Java用户
    }
}
//leetcode submit region end(Prohibit modification and deletion)
