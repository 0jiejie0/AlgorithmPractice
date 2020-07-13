package test.problemAndSolving.leetcode_20200713;

import junit.framework.TestCase;
import main.problemAndSolving.leetcode_20200713.Solution;
import org.junit.Assert;

public class SolutionTest extends TestCase {
    Solution solution;

    public void setUp() throws Exception {
        super.setUp();
        solution=new Solution();
    }

    public void tearDown() throws Exception {
    }

    public void testSearchInsert() {
        Assert.assertEquals(2,solution.searchInsert(new int[]{1,3,5,6}, 5));
        Assert.assertEquals(1,solution.searchInsert(new int[]{1,3,5,6}, 2));
        Assert.assertEquals(4,solution.searchInsert(new int[]{1,3,5,6}, 7));
        Assert.assertEquals(0,solution.searchInsert(new int[]{1,3,5,6}, 0));
    }
}