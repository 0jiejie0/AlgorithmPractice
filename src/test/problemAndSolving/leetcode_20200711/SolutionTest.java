package test.problemAndSolving.leetcode_20200711;

import junit.framework.TestCase;
import main.problemAndSolving.leetcode.leetcode_20200711.Solution;
import org.junit.Assert;

public class SolutionTest extends TestCase {
    Solution solution;

    public void setUp() throws Exception {
        super.setUp();
        solution = new Solution();
    }

    public void tearDown() throws Exception {
    }

    public void testStrStr() {
        Assert.assertEquals(2, solution.strStr("hello", "ll"));
    }
}