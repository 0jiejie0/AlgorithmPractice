package main.leetcode.editor.cn;//请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
//
// 实现 MyQueue 类： 
//
// 
// void push(int x) 将元素 x 推到队列的末尾 
// int pop() 从队列的开头移除并返回元素 
// int peek() 返回队列开头的元素 
// boolean empty() 如果队列为空，返回 true ；否则，返回 false 
// 
//
// 说明： 
//
// 
// 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法
//的。 
// 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["MyQueue", "push", "push", "peek", "pop", "empty"]
//[[], [1], [2], [], [], []]
//输出：
//[null, null, null, 1, 1, false]
//
//解释：
//MyQueue myQueue = new MyQueue();
//myQueue.push(1); // queue is: [1]
//myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
//myQueue.peek(); // return 1
//myQueue.pop(); // return 1, queue is [2]
//myQueue.empty(); // return false
// 
//
// 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= x <= 9 
// 最多调用 100 次 push、pop、peek 和 empty 
// 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作） 
// 
//
// 
//
// 进阶： 
//
// 
// 你能否实现每个操作均摊时间复杂度为 O(1) 的队列？换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间。 
// 
//
// Related Topics 栈 设计 队列 👍 1162 👎 0


import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class MyQueue {
    LinkedList<Integer> stackA;
    LinkedList<Integer> stackB;
    boolean pushed = false;

    public MyQueue() {
        stackA = new LinkedList<>();
        stackB = new LinkedList<>();
    }

    public void push(int x) {
        if (!pushed) {
            int n = stackA.size();
            while (n-- > 0) {
                stackB.push(stackA.pop());
            }
            pushed = true;
        }
        stackB.push(x);
    }

    public int pop() {
        peek();
        return stackA.pop();
    }

    public int peek() {
        if (pushed) {
            int n = stackB.size();
            while (n-- > 0) {
                stackA.push(stackB.pop());
            }
            pushed = false;
        }
        return stackA.peek();
    }

    public boolean empty() {
        return pushed ? stackB.isEmpty() : stackA.isEmpty();
    }
}

// 	执行耗时:0 ms,击败了100.00% 的Java用户
//	内存消耗:40.4 MB,击败了46.68% 的Java用户
// 本来以为有什么优化的好方法，有人顶头写上方法一：双栈，赶紧往下翻看看有什么更好的方案，结果毛都没了

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)
