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
//
//
// 用自己写的链表，性能提升效果并不明显
//
//  执行耗时:6 ms,击败了97.18% 的Java用户
//		内存消耗:41.5 MB,击败了58.40% 的Java用户
//	执行耗时:5 ms,击败了99.92% 的Java用户
//		内存消耗:41.5 MB,击败了61.81% 的Java用户
//	执行耗时:6 ms,击败了97.18% 的Java用户
//		内存消耗:41.6 MB,击败了50.12% 的Java用户

public class MinStack {
    class Node {
        int val;
        Node last;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node last) {
            this.val = val;
            this.last = last;
        }

        public Node() {
        }
    }

    //    List<Integer> data;
//    List<Integer> min;
    int size;
    Node data;
    Node min;

    public MinStack() {
//        data = new LinkedList<>();
//        min = new LinkedList<>();
        size = 0;
        data = new Node();
        min = new Node();
    }

    public void push(int x) {
//        data.add(x);
//        if (min.size() == 0 || min.get(min.size() - 1) >= x) {
//            min.add(x);
//        }
        data = new Node(x, data);
        if (size == 0 || min.val >= x) {
            min = new Node(x, min);
        }
        size++;
    }

    public void pop() {
//        int a = data.remove(data.size() - 1);
//        if (a == min.get(min.size() - 1)) {
//            min.remove(min.size() - 1);
//        }
        if (data.val == min.val) {
            min = min.last;
        }
        data = data.last;
        size--;
    }

    public int top() {
//        return data.get(data.size() - 1);
        return data.val;
    }

    public int getMin() {
//        return min.get(min.size() - 1);
        return min.val;
    }
}
