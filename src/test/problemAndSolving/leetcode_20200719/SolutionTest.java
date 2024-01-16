package test.problemAndSolving.leetcode_20200719;

import junit.framework.TestCase;
import main.problemAndSolving.leetcode.leetcode_20200719.Solution;
import org.junit.Assert;

public class SolutionTest extends TestCase {
    Solution solution;

    public void setUp() throws Exception {
        super.setUp();
        solution = new Solution();
    }

    public void tearDown() throws Exception {
    }

    public void testPlusOne() {
        Assert.assertArrayEquals(new int[]{1}, solution.plusOne(new int[]{0}));
        Assert.assertArrayEquals(new int[]{1, 2, 4}, solution.plusOne(new int[]{1, 2, 3}));
        Assert.assertArrayEquals(new int[]{1, 0}, solution.plusOne(new int[]{9}));
    }
}