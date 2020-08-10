package test.problemAndSolving.leetcode_20200809WeekRankList;

import junit.framework.TestCase;
import main.problemAndSolving.leetcode_20200809WeekRankList.T1545找出第N个二进制字符串中的第K位;
import org.junit.Assert;

public class T1545找出第N个二进制字符串中的第K位Test extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testFindKthBit() {
        Assert.assertEquals('0', new T1545找出第N个二进制字符串中的第K位().findKthBit(3, 5));
    }
}