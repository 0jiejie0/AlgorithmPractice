package test.problemAndSolving.leetcode_20201101RankList;

import junit.framework.TestCase;
import main.problemAndSolving.leetcode.leetcode_20201101RankList.T5555统计字典序元音字符串的数目;
import org.junit.Assert;

public class T5555统计字典序元音字符串的数目Test extends TestCase {
    T5555统计字典序元音字符串的数目 exam;

    public void setUp() throws Exception {
        super.setUp();
        exam = new T5555统计字典序元音字符串的数目();
    }

    public void tearDown() throws Exception {
    }

    public void testCountVowelStrings() {
        Assert.assertEquals(5, exam.countVowelStrings(1));
        Assert.assertEquals(15, exam.countVowelStrings(2));
        Assert.assertEquals(66045, exam.countVowelStrings(33));//本条数据通不过
    }
}
