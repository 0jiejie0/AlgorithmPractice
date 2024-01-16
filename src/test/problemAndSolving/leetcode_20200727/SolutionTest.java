package test.problemAndSolving.leetcode_20200727;

import junit.framework.TestCase;
import main.problemAndSolving.leetcode.leetcode_20200727.Solution;
import org.junit.Assert;

public class SolutionTest extends TestCase {
    Solution solution;

    public void setUp() throws Exception {
        super.setUp();
        solution = new Solution();
    }

    public void tearDown() throws Exception {
    }

    public void testAddBinary() {
        Assert.assertEquals("100", solution.addBinary("11", "1"));
        Assert.assertEquals("10101", solution.addBinary("1010", "1011"));
    }
}