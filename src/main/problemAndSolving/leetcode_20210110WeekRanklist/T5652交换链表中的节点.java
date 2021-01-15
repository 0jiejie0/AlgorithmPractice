package main.problemAndSolving.leetcode_20210110WeekRanklist;
//给你链表的头节点 head 和一个整数 k 。
//
//交换 链表正数第 k 个节点和倒数第 k 个节点的值后，返回链表的头节点（链表 从 1 开始索引）。
//
// 
//
//示例 1：
//
//
//输入：head = [1,2,3,4,5], k = 2
//输出：[1,4,3,2,5]
//示例 2：
//
//输入：head = [7,9,6,6,7,8,3,0,9,5], k = 5
//输出：[7,9,6,6,8,7,3,0,9,5]
//示例 3：
//
//输入：head = [1], k = 1
//输出：[1]
//示例 4：
//
//输入：head = [1,2], k = 1
//输出：[2,1]
//示例 5：
//
//输入：head = [1,2,3], k = 2
//输出：[1,2,3]
// 
//
//提示：
//
//链表中节点的数目是 n
//1 <= k <= n <= 105
//0 <= Node.val <= 100
public class T5652交换链表中的节点 {
    public ListNode swapNodes(ListNode head, int k) {
        //三指针，k，i-k，i（i探测到链表尾）
        ListNode beforeK, tailK, tailP;
        tailP = head;
        for (int i = 1; i < k; i++) {
            tailP = tailP.next;
        }
        beforeK = tailP;
        tailK = head;
        //搜索倒数第k点
        while (tailP.next != null) {
            tailK = tailK.next;
            tailP = tailP.next;
        }
        int temp = beforeK.val;
        beforeK.val = tailK.val;
        tailK.val = temp;
        return head;
    }
}
