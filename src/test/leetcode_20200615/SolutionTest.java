package test.leetcode_20200615;

import main.leetcode_20200615.Solution;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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
    public void romanToInt() {
        Assert.assertEquals(3,solution.romanToInt("III"));
        Assert.assertEquals(4,solution.romanToInt("IV"));
        Assert.assertEquals(9,solution.romanToInt("IX"));
        Assert.assertEquals(58,solution.romanToInt("LVIII"));
        Assert.assertEquals(1994,solution.romanToInt("MCMXCIV"));
    }
}