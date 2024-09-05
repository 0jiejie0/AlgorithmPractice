package main.customUtil;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 主要负责字符串型数据和各种类型对象的转换
 * <p>
 * 主要包括如下几类功能
 * 1. 字符串转成各类型对象的各方法
 * 2. 各类型对象转换成字符串的方法
 * 3. 按指定类型转换数据成相应对象的方法
 * 4. 按指定各种类型的列表，依次转换数据列表中的各数据，组装成相应对象列表的方法
 *
 * @author O
 */
public class Convert {

    /**
     * 按指定各种类型的列表，依次转换数据列表中的各数据，组装成相应对象列表
     *
     * @param typesClass 类型的class列表
     * @param params     数据列表
     * @return 对象列表
     * @throws Exception
     */
    public static Object[] toInstances(Class<?>[] typesClass, String[] params) throws Exception {
        if (null == typesClass || null == params) {
            throw new Exception("实参列表或形参类型列表为空!");
        } else if (typesClass.length != params.length) {
            throw new Exception("实参列表(" + params.length + ")参数类型列表(" + typesClass.length + ")长度不一致!");
        }
        Object[] ans = new Object[typesClass.length];
        for (int i = 0; i < typesClass.length; i++) {
            ans[i] = toInstance(typesClass[i], params[i]);
        }
        return ans;
    }

    /**
     * 将数据根据指定类型（借助各转化方法）转换成相应对象
     *
     * @param typeClass
     * @param param
     * @return
     */
    public static Object toInstance(Class<?> typeClass, String param) {
        Object ans = null;
        if (int.class.equals(typeClass)) {
            ans = toInteger(param);
        } else if (String.class.equals(typeClass)) {
            ans = toString(param);
        }
        return ans;
    }

    public static String toString(Object o) {
        return toString(o, null);
    }

    public static String toString(Object o, String[] surrounds) {
        return toString(o, surrounds, null);
    }

    /**
     * 按对象类型，分门别类对对象作相应处理
     *
     * @param o
     * @param surrounds     列表、数组类型要加注的前后缀
     * @param joinDelimiter 列表、数组类型元素间的分隔符
     * @return
     */
    public static String toString(Object o, String[] surrounds, String joinDelimiter) {
        if (null == o) {
            return "";
        }
        if (Class.class.equals(o.getClass())) {
            return ((Class<?>) o).getName();
        } else if (o.getClass().isArray()) {
            return toString(Stream.of((Object[]) o), surrounds, joinDelimiter);  // Object数组调用Stream方式处理
        } else if (o instanceof List) {
            return toString(((List<?>) o).toArray(), surrounds, joinDelimiter);  // List对象转为Object数组
        }
        return String.valueOf(o);
    }

    /**
     * 将stream流中的元素组装为字符串，默认使用逗号分隔符、两端无括号
     *
     * @param stream
     * @param surrounds
     * @param joinDelimiter
     * @return
     */
    public static String toString(Stream<?> stream, String[] surrounds, String joinDelimiter) {
        if (null == stream) {
            return "";
        }
        if (null == joinDelimiter) {
            joinDelimiter = ", ";
        }
        if (null == surrounds || surrounds.length < 2) {
            surrounds = new String[]{"", ""};
        }
        return surrounds[0] + stream.map(Convert::toString).collect(Collectors.joining(joinDelimiter)) + surrounds[1];
    }

    public static Integer toInteger(Object o) {
        if (null == o) {
            return 0;
        }
        return Integer.parseInt(o.toString());
    }
}
