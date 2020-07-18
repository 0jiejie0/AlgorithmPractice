package test.problemAndSolving.leetcode_20200718;

import junit.framework.TestCase;
import main.problemAndSolving.leetcode_20200718.Solution;
import org.junit.Assert;

public class SolutionTest extends TestCase {
    Solution solution;

    public void setUp() throws Exception {
        super.setUp();
        solution = new Solution();
    }

    public void tearDown() throws Exception {
    }

    public void testLengthOfLastWord() {
        Assert.assertEquals(5, solution.lengthOfLastWord("Hello World"));
        Assert.assertEquals(0, solution.lengthOfLastWord(" "));
        Assert.assertEquals(0, solution.lengthOfLastWord("  "));
    }
}