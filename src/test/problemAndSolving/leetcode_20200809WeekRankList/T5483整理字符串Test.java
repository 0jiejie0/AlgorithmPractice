package test.problemAndSolving.leetcode_20200809WeekRankList;

import junit.framework.TestCase;
import main.problemAndSolving.leetcode.leetcode_20200809WeekRankList.T5483整理字符串;
import org.junit.Assert;

public class T5483整理字符串Test extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testMakeGood() {
        Assert.assertEquals("leetcode", new T5483整理字符串().makeGood("leEeetcode"));
        Assert.assertEquals("", new T5483整理字符串().makeGood("abBAcC"));
        Assert.assertEquals("s", new T5483整理字符串().makeGood("s"));
    }
}