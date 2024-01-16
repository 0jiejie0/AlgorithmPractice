package test.problemAndSolving.leetcode_20200707;

import main.problemAndSolving.leetcode.leetcode_20200707.Solution;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {
    private Solution solution;

    @Before
    public void setUp() throws Exception {
        solution = new Solution();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void longestCommonPrefix() {
        System.out.println(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }
}