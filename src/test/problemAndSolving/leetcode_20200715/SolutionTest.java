package test.problemAndSolving.leetcode_20200715;

import junit.framework.TestCase;
import main.problemAndSolving.leetcode.leetcode_20200715.Solution;
import org.junit.Assert;

public class SolutionTest extends TestCase {
    Solution solution;

    public void setUp() throws Exception {
        super.setUp();
        solution = new Solution();
    }

    public void tearDown() throws Exception {
    }

    public void testMaxSubArray() {
        Assert.assertEquals(6, solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        Assert.assertEquals(-1, solution.maxSubArray(new int[]{-2, -1}));
        Assert.assertEquals(-2, solution.maxSubArray(new int[]{-2, -2}));
        Assert.assertEquals(-1, solution.maxSubArray(new int[]{-1, -2}));
    }
}