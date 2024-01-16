package test.problemAndSolving.leetcode_20201122WeekRankList;

import junit.framework.TestCase;
import main.problemAndSolving.leetcode.leetcode_20201122WeekRankList.T5606具有给定数值的最小字符串;

public class T5606具有给定数值的最小字符串Test extends TestCase {
    T5606具有给定数值的最小字符串 exam;

    public void setUp() throws Exception {
        super.setUp();
        exam = new T5606具有给定数值的最小字符串();
    }

    public void tearDown() throws Exception {
    }

    public void testGetSmallestString() {
//        assertEquals("aaabz", exam.getSmallestString(5, 31));
//        assertEquals("aay", exam.getSmallestString(3, 27));
        assertEquals("aaszz", exam.getSmallestString(5, 73));
//        assertEquals("aaszz", exam.getSmallestString(74657, 743771));
    }
}