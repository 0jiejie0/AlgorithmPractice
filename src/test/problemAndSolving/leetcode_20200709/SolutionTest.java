package test.problemAndSolving.leetcode_20200709;

import junit.framework.TestCase;
import main.problemAndSolving.leetcode.leetcode_20200709.ListNode;
import main.problemAndSolving.leetcode.leetcode_20200709.Solution;

public class SolutionTest extends TestCase {
    Solution solution;

    public void setUp() throws Exception {
        super.setUp();
        solution = new Solution();
    }

    public void tearDown() throws Exception {
    }

    public void testMergeTwoLists() {
        ListNode head = solution.mergeTwoLists(
                ListNode.createList(new int[]{1, 2, 4}),
                ListNode.createList(new int[]{1, 3, 4})
        );
        System.out.println(head.toString());
    }
}