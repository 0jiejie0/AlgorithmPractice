package test.problemAndSolving.leetcode_20201213WeekRankList;

import junit.framework.TestCase;
import main.problemAndSolving.leetcode.leetcode_20201213WeekRankList.T5245堆叠长方体的最大高度;

public class T5245堆叠长方体的最大高度Test extends TestCase {
    T5245堆叠长方体的最大高度 exam;

    public void setUp() throws Exception {
        super.setUp();
        exam = new T5245堆叠长方体的最大高度();
    }

    public void tearDown() throws Exception {
    }

    public void testMaxHeight() {
        assertEquals(190, exam.maxHeight(new int[][]{{50, 45, 20}, {95, 37, 53}, {45, 23, 12}}));
    }
}