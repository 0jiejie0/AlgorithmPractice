package main.leetcode_20200708;
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
// 注意空字符串可被认为是有效字符串。
//
// 示例 1:
//
// 输入: "()"
//输出: true
//
//
// 示例 2:
//
// 输入: "()[]{}"
//输出: true
//
//
// 示例 3:
//
// 输入: "(]"
//输出: false
//
//
// 示例 4:
//
// 输入: "([)]"
//输出: false
//
//
// 示例 5:
//
// 输入: "{[]}"
//输出: true
// Related Topics 栈 字符串
//一遍过 用时15m
// 执行耗时:1 ms,击败了98.68% 的Java用户
// 内存消耗:37.6 MB,击败了5.48% 的Java用户

import java.util.Stack;

public class Soultion {
    public boolean isValid(String s) {
        if (s == null || "".equals(s)) {//防范非法输入和空串
            return true;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '(':
                case '[':
                case '{':
                    stack.push(chars[i]);//压栈条件合并
                    break;
                case ')':
                    if (stack.empty() || '(' != stack.peek()) {//当栈顶为空，或栈顶符号不匹配时，返回false退出
                        return false;
                    }
                    stack.pop();
                    break;
                case ']':
                    if (stack.empty() || '[' != stack.peek()) {
                        return false;
                    }
                    stack.pop();
                    break;
                case '}':
                    if (stack.empty() || '{' != stack.peek()) {
                        return false;
                    }
                    stack.pop();
                    break;
            }
        }
        return stack.empty();
    }
}
