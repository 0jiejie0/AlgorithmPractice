package test.algo._01BitOperation;

import junit.framework.TestCase;
import main.customUtil.Print;

import java.util.Random;

import static main.algo._01BitOperation.唯一成对数.auxiliarySpace;
import static main.algo._01BitOperation.唯一成对数.bitOp;

/**
 * 测试结果表明，位运算的速度和性能要优于辅助空间3-8倍
 */
public class 唯一成对数Test extends TestCase {
    int N = 11;
    int[] arr = new int[N];

    public void setUp() throws Exception {
        System.out.println("start=========");
        super.setUp();
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = i + 1;
        }
        int tempIndex = new Random().nextInt(arr.length);
        arr[arr.length - 1] = arr[tempIndex];//随机挪动一个位置
        arr[tempIndex] = new Random().nextInt(arr.length - 1) + 1;//在挪出的空位加随机数
        Print.arrayStandard(arr);
    }

    public void tearDown() throws Exception {
        System.out.println("end==========");
    }

    public void testAuxiliarySpace() {
        System.out.println("=======AuxiliarySpace========");
        System.out.println(auxiliarySpace(arr));
    }

    public void testBitOp() {
        System.out.println("=======BitOp========");
        System.out.println(bitOp(arr));
    }
}