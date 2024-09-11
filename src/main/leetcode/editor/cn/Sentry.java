package main.leetcode.editor.cn;

import java.lang.reflect.Method;

/**
 * 用来帮助轻量级框架，获取和文件不同名的类（leetcode插件代码）的实例对象
 *
 * @author O
 */
public class Sentry {
    public Object seek(Method method) throws Exception {
        return method.getDeclaringClass().getDeclaredConstructor().newInstance();
    }
}
