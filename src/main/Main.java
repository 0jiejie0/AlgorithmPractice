package main;

import main.customUtil.AssertExample;
import main.customUtil.AssertExamples;
import main.customUtil.Task;

import java.util.*;

import static main.customUtil.Loader.getClasses;
import static main.customUtil.Loader.loadClassFiles;

/**
 * 测试框架启动类
 *
 * @author O
 */
public class Main {
    public static void main(String[] args) throws Exception {
        long start = Task.getTimeStamp();
        System.out.println("测试程序已启动，时间戳：" + start);
        loadClassFiles();  // 加载类文件，内部文件列表为全局变量，若多次加载文件，需要重新调整其内部结构
        List<Class<?>> classList = getClasses(new Class[]{AssertExample.class, AssertExamples.class});  // 文件转化为class对象，筛选可运行类
        new Task(classList).testClasses();
        long end = Task.getTimeStamp();
        System.out.println("测试程序已启动，时间戳：" + end + "，总计用时（ms）：" + (end - start));
    }
}
