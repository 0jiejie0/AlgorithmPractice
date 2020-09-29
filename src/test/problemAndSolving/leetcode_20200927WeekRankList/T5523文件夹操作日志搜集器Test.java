package test.problemAndSolving.leetcode_20200927WeekRankList;

import junit.framework.TestCase;
import main.problemAndSolving.leetcode_20200927WeekRankList.T5523文件夹操作日志搜集器;
import org.junit.Assert;

public class T5523文件夹操作日志搜集器Test extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testMinOperations() {
        Assert.assertEquals(0, new T5523文件夹操作日志搜集器().minOperations(new String[]{"./", "../", "./"}));
    }
}