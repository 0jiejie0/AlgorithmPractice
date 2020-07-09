package test.problemAndSolving.leetcode_20200614;

import main.problemAndSolving.leetcode_20200614.Solution;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {
    Solution solution;

    @Before
    public void setUp() throws Exception {
        solution = new Solution();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isPalindrome() {
        Assert.assertEquals(true,solution.isPalindrome(0));
        Assert.assertEquals(true,solution.isPalindrome(101));
        Assert.assertEquals(true,solution.isPalindrome(909));
        Assert.assertEquals(false,solution.isPalindrome(90));
        Assert.assertEquals(false,solution.isPalindrome(1000));
        Assert.assertEquals(false,solution.isPalindrome(10));
    }
}