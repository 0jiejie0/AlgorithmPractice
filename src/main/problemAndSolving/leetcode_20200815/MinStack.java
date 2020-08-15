package main.problemAndSolving.leetcode_20200815;
//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//
//
// push(x) —— 将元素 x 推入栈中。
// pop() —— 删除栈顶的元素。
// top() —— 获取栈顶元素。
// getMin() —— 检索栈中的最小元素。
//
//
//
//
// 示例:
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
//
//
//
//
// 提示：
//
//
// pop、top 和 getMin 操作总是在 非空栈 上调用。
//
// Related Topics 栈 设计
// 借助LinkList写起来比较简单，但是性能不够好，用时17m
// 执行耗时:7 ms,击败了78.91% 的Java用户
//		内存消耗:41.7 MB,击败了25.12% 的Java用户

import java.util.LinkedList;
import java.util.List;

public class MinStack {
    List<Integer> data;
    List<Integer> min;

    public MinStack() {
        data = new LinkedList<>();
        min = new LinkedList<>();
    }

    public void push(int x) {
        data.add(x);
        if (min.size() == 0 || min.get(min.size() - 1) >= x) {
            min.add(x);
        }
    }

    public void pop() {
        int a = data.remove(data.size() - 1);
        if (a == min.get(min.size() - 1)) {
            min.remove(min.size() - 1);
        }
    }

    public int top() {
        return data.get(data.size() - 1);
    }

    public int getMin() {
        return min.get(min.size() - 1);
    }
}
