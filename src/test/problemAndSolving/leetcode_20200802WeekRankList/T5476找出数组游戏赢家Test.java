package test.problemAndSolving.leetcode_20200802WeekRankList;

import junit.framework.TestCase;
import main.problemAndSolving.leetcode.leetcode_20200802WeekRankList.T5476找出数组游戏赢家;
import org.junit.Assert;

public class T5476找出数组游戏赢家Test extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testGetWinner() {
        Assert.assertEquals(25, new T5476找出数组游戏赢家().getWinner(new int[]{1, 25, 35, 42, 68, 70}, 1));
    }
}