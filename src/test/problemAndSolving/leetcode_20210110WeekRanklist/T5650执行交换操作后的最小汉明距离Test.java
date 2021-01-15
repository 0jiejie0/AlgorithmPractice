package test.problemAndSolving.leetcode_20210110WeekRanklist;

import junit.framework.TestCase;
import main.problemAndSolving.leetcode_20210110WeekRanklist.T5650执行交换操作后的最小汉明距离;

public class T5650执行交换操作后的最小汉明距离Test extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testMinimumHammingDistance() {
        assertEquals(1, new T5650执行交换操作后的最小汉明距离().
                minimumHammingDistance(new int[]{1, 2, 3, 4}, new int[]{2, 1, 4, 5},
                        new int[][]{new int[]{0, 1}, new int[]{2, 3}}));
        assertEquals(2, new T5650执行交换操作后的最小汉明距离().
                minimumHammingDistance(new int[]{1, 2, 3, 4}, new int[]{1, 3, 2, 4},
                        new int[][]{}));
    }
}