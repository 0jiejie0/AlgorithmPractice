package test.problemAndSolving.leetcode_20200728;

import junit.framework.TestCase;
import main.problemAndSolving.leetcode_20200728.Solution;
import org.junit.Assert;

public class SolutionTest extends TestCase {
    Solution solution;

    public void setUp() throws Exception {
        super.setUp();
        solution = new Solution();
    }

    public void tearDown() throws Exception {
    }

    public void testMySqrt() {
        Assert.assertEquals(2, solution.mySqrt(5));
        Assert.assertEquals(2, solution.mySqrt(4));
        Assert.assertEquals(2, solution.mySqrt(8));
        Assert.assertEquals(9, solution.mySqrt(89));
        Assert.assertEquals(9, solution.mySqrt(81));
        Assert.assertEquals(8, solution.mySqrt(80));
        Assert.assertEquals(46339, solution.mySqrt(2147395599));
    }
}