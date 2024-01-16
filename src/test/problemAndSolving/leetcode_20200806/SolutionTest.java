package test.problemAndSolving.leetcode_20200806;

import junit.framework.TestCase;
import main.problemAndSolving.leetcode.leetcode_20200806.Solution;
import main.problemAndSolving.leetcode.leetcode_20200806.TreeNode;
import org.junit.Assert;

public class SolutionTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testIsSameTree() {
        Assert.assertEquals(true, new Solution().isSameTree(new TreeNode(1), new TreeNode(1)));
        Assert.assertEquals(false, new Solution().isSameTree(new TreeNode(1), new TreeNode(2)));
    }
}