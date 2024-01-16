package main.problemAndSolving.leetcode.leetcode_20220703WeekRankList;

//给你两个整数：m 和 n ，表示矩阵的维数。
//
//另给你一个整数链表的头节点 head 。
//
//请你生成一个大小为 m x n 的螺旋矩阵，矩阵包含链表中的所有整数。链表中的整数从矩阵 左上角 开始、顺时针 按 螺旋 顺序填充。如果还存在剩余的空格，则用 -1 填充。
//
//返回生成的矩阵。
//
//
//
//示例 1：
//
//
//输入：m = 3, n = 5, head = [3,0,2,6,8,1,7,9,4,2,5,5,0]
//输出：[[3,0,2,6,8],[5,0,-1,-1,1],[5,2,4,9,7]]
//解释：上图展示了链表中的整数在矩阵中是如何排布的。
//注意，矩阵中剩下的空格用 -1 填充。
//示例 2：
//
//
//输入：m = 1, n = 4, head = [0,1,2]
//输出：[[0,1,2,-1]]
//解释：上图展示了链表中的整数在矩阵中是如何从左到右排布的。
//注意，矩阵中剩下的空格用 -1 填充。
//
//
//提示：
//
//1 <= m, n <= 105
//1 <= m * n <= 105
//链表中节点数目在范围 [1, m * n] 内
//0 <= Node.val <= 1000
public class T6111螺旋矩阵IV {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        int i = 0, j = 0;
        ListNode start = new ListNode();//头上加个空节点
        start.next = head;
        while (m - j > 0 && n - i > 0) {
            for (int k = i; k < n - 1; k++) {
                fill(res, j, k, start);
            }
            for (int k = j; k < m - 1; k++) {
                fill(res, k, n - 1, start);
            }
            if (j == m - 1 || i == n - 1) {//最后一行或最后一列
                fill(res, m - 1, n - 1, start);//填补最后一格
                break;
            }
            for (int k = n - 1; k > i; k--) {
                fill(res, m - 1, k, start);
            }
            for (int k = m - 1; k > j; k--) {
                fill(res, k, i, start);
            }
            i++;
            j++;
            m--;
            n--;
        }
        return res;
    }

    private void fill(int[][] cache, int i, int j, ListNode head) {
        if (head.next == null) {
            head.next = head;
            head.val = -1;
        }
        cache[i][j] = head.next.val;
        head.next = head.next.next;
    }
}
//输入：
//4
//5
//[515,942,528,483,20,159,868,999,474,320,734,956,12,124,224,252,909,732]
//输出：
//[[515,942,528,483,20],
// [124,224,-1 ,909,159],
// [12 ,-1 ,-1 ,732,868],
// [956,734,320,474,999]]
//预期：
//[[515,942,528,483,20],
// [124,224,252,909,159],
// [12 ,-1 ,-1 ,732,868],
// [956,734,320,474,999]]