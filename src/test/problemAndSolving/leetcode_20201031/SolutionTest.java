package test.problemAndSolving.leetcode_20201031;

import junit.framework.TestCase;
import main.problemAndSolving.leetcode_20201031.Solution;
import org.junit.Assert;

public class SolutionTest extends TestCase {
    Solution solution;

    public void setUp() throws Exception {
        super.setUp();
        solution = new Solution();
    }

    public void tearDown() throws Exception {
    }

    public void testTitleToNumber() {
    }

    public void testTrailingZeroes() {
        Assert.assertEquals(1, solution.trailingZeroes(5));
        Assert.assertEquals(3, solution.trailingZeroes(15));
        Assert.assertEquals(7, solution.trailingZeroes(30));
        Assert.assertEquals(12, solution.trailingZeroes(50));
    }
}