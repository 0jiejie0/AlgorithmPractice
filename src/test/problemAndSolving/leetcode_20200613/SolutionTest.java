package test.problemAndSolving.leetcode_20200613;

import main.problemAndSolving.leetcode.leetcode_20200613.Solution;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void reverse() {
        Assert.assertEquals(123, new Solution().reverse(321));
        Assert.assertEquals(-123, new Solution().reverse(-321));
        Assert.assertEquals(0, new Solution().reverse(0));
    }
}