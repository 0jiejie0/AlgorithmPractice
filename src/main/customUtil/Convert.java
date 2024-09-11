package main.customUtil;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
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
     * 按指定各元素类型的列表，依次转换数据列表中的各数据，组装成相应对象列表
     *
     * @param typesClass 类型的Class列表
     * @param params     数据字符串列表
     * @return 对象列表
     * @throws Exception 类型列表和数据列表为空或长度不一致时，抛出异常中止运行
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
     * 将数据字符串根据指定类型转换成相应对象
     *
     * @param typeClass 对象的Class类型
     * @param param     数据字符串
     * @return 类型匹配失败时返回null
     */
    public static Object toInstance(Class<?> typeClass, String param) {
        Object ans = null;
        if (int.class.equals(typeClass) || Integer.class.equals(typeClass)) {
            ans = toInteger(param);
        } else if (boolean.class.equals(typeClass) || Boolean.class.equals(typeClass)) {
            ans = toBoolean(param);
        } else if (String.class.equals(typeClass)) {
            ans = toString(param);
        } else if (typeClass.isArray()) {
            ans = toArray(typeClass.getComponentType(), param);
        } else if (List.class.isAssignableFrom(typeClass)) {
            Class<?> actualTypeArgument = (Class<?>) ((ParameterizedType) typeClass.getGenericSuperclass()).getActualTypeArguments()[0];
            ans = toList(actualTypeArgument, param);
        }
        return ans;
    }

    /**
     * 按不同数组类型，将入参对象转换为数组对象
     *
     * @param elementType 数组元素类型
     * @param o           要转换为数组的对象
     * @return 数组类型未匹配成功时，返回 new Object[]{}
     */
    public static Object toArray(Class<?> elementType, Object o) {
        return toArray(elementType, o, null);
    }

    /**
     * 按不同数组类型，将入参对象转换为数组对象
     *
     * @param elementType 数组元素类型
     * @param o           要转换为数组的对象
     * @param surrounds   前后缀
     * @return 数组类型未匹配成功时，返回 new Object[]{}
     */
    public static Object toArray(Class<?> elementType, Object o, String[] surrounds) {
        return toArray(elementType, o, surrounds, null);
    }

    /**
     * 按不同数组类型，将入参对象转换为数组对象
     *
     * @param elementType 数组元素类型
     * @param o           要转换为数组的对象
     * @param surrounds   前后缀
     * @param delimiter   分隔符
     * @return 数组类型未匹配成功时，返回 new Object[]{}
     */
    public static Object toArray(Class<?> elementType, Object o, String[] surrounds, String delimiter) {
        List<?> list = toList(elementType, o, surrounds, delimiter);// 如果直接将List转成数组，泛型信息会丢失，这里需要二次处理
        if (int.class.equals(elementType)) {
            return toIntArray(list);  // 基本数据类型数组需要单独处理
        } else if (Integer.class.equals(elementType)) {
            return list.toArray(new Integer[0]);
        } else if (String.class.equals(elementType)) {
            return list.toArray(new String[0]);
        }
        return new Object[]{};
    }

    /**
     * 将List列表转换为int数组
     *
     * @param list
     * @return
     */
    public static int[] toIntArray(List<?> list) {
        int[] ansArray = (int[]) Array.newInstance(int.class, list.size());
        for (int i = 0; i < list.size(); i++) {
            ansArray[i] = toInteger(list.get(i));
        }
        return ansArray;
    }

    /**
     * 将对象转换为List列表
     *
     * @param elementType 指定元素类型
     * @param o           要转为列表的对象
     * @return List列表（ArrayList对象）
     */
    public static List<?> toList(Class<?> elementType, Object o) {
        return toList(elementType, o, null, null);
    }

    /**
     * 将对象转换为List列表
     *
     * @param elementType 指定元素类型
     * @param o           要转为列表的对象
     * @param surrounds   前后缀，默认使用 new String[]{"[", "]"}
     * @param delimiter   分隔符，默认使用 ","（无空格）
     * @return List列表（ArrayList对象）
     */
    public static List<?> toList(Class<?> elementType, Object o, String[] surrounds, String delimiter) {
        List<Object> ansObjectList = new ArrayList<>();
        if (null == o) {
            return ansObjectList;
        }
        if (null == delimiter) {
            delimiter = ",";  // 分隔符默认不带空格
        }
        if (null == surrounds || surrounds.length < 2) {
            surrounds = new String[]{"[", "]"};
        }
        String dataString = toString(o);
        if (0 == dataString.indexOf(surrounds[0])) {  // 剔除前缀
            dataString = dataString.substring(surrounds[0].length());
        }
        if (dataString.length() - surrounds[1].length() == dataString.indexOf(surrounds[1])) {  // 剔除后缀（列表内元素及分隔符不包含后缀的情况下，否则有bug）
            dataString = dataString.substring(0, dataString.length() - surrounds[1].length());
        }
        String[] dataStrings = dataString.split(delimiter);
        for (String dataStr : dataStrings) {
            ansObjectList.add(toInstance(elementType, dataStr));
        }
        return ansObjectList;
    }

    /**
     * 检查对象类型，分门别类对对象作相应处理
     *
     * @param o 要获取字符串的对象
     * @return 未能识别类型的对象，返回String.valueOf(o)值
     */
    public static String toString(Object o) {
        return toString(o, null);
    }

    /**
     * 检查对象类型，分门别类对对象作相应处理
     *
     * @param o         要获取字符串的对象
     * @param surrounds 列表、数组类型要加注的前后缀
     * @return 未能识别类型的对象，返回String.valueOf(o)值
     */
    public static String toString(Object o, String[] surrounds) {
        return toString(o, surrounds, null);
    }

    /**
     * 检查对象类型，分门别类对对象作相应处理
     *
     * @param o             要获取字符串的对象
     * @param surrounds     列表、数组类型要加注的前后缀
     * @param joinDelimiter 列表、数组类型元素间的分隔符
     * @return 未能识别类型的对象，返回String.valueOf(o)值
     */
    public static String toString(Object o, String[] surrounds, String joinDelimiter) {
        if (null == o) {
            return "";
        }
        if (Class.class.equals(o.getClass())) {
            Class<?> oClass = (Class<?>) o;
            return oClass.isArray() ? oClass.getComponentType().getName() + "[]" : oClass.getName();  // 数组类型使用元素类型加方括号表示
        } else if (String.class.equals(o.getClass())) {
            return o.toString();
        } else if (o.getClass().isArray()) {
            return toArrayString(o, surrounds, joinDelimiter);
        } else if (o instanceof List) {
            return toString(((List<?>) o).toArray(), surrounds, joinDelimiter);  // List对象转为Object数组
        }
        return String.valueOf(o);
    }

    /**
     * 将数组转换为字符串
     * <p>
     * （由于数组类型不能直接转换，所以）根据元素类型，对不同数组作相应转换处理
     *
     * @param o             数组对象
     * @param surrounds     前后缀，默认使用方括号 new String[]{"[", "]"}
     * @param joinDelimiter 分隔符，默认使用", "
     * @return 未能识别的元素类型返回其String.valueOf(o) + "-ArrStr"值
     */
    public static String toArrayString(Object o, String[] surrounds, String joinDelimiter) {
        // 分隔符和前后缀字符统一处理，各类型子方法不再校验，故设为私有
        if (null == o) {
            return "";
        }
        if (null == joinDelimiter) {
            joinDelimiter = ", ";
        }
        if (null == surrounds || surrounds.length < 2) {
            surrounds = new String[]{"[", "]"};
        }
        // 各类型数组分别(数组类型不同无法直接向父类强转)强制类型转换，调用Stream方式处理
        if (Class.class.equals(o.getClass().getComponentType())) {
            return toObjectArrayString(Arrays.stream((Class[]) o), surrounds, joinDelimiter);
        } else if (Integer.class.equals(o.getClass().getComponentType())) {
            return toObjectArrayString(Arrays.stream((Integer[]) o), surrounds, joinDelimiter);
        } else if (String.class.equals(o.getClass().getComponentType())) {
            return toObjectArrayString(Arrays.stream((String[]) o), surrounds, joinDelimiter);
        } else if (Object.class.equals(o.getClass().getComponentType())) {
            return toObjectArrayString(Arrays.stream((Object[]) o), surrounds, joinDelimiter);
        } else if (int.class.equals(o.getClass().getComponentType())) {
            return toIntArrayString(((int[]) o), surrounds, joinDelimiter);
        }
        return String.valueOf(o) + "-ArrStr";
    }

    /**
     * 将int数组转换为字符串
     *
     * @param array         int数组
     * @param surrounds     前后缀（括号）
     * @param joinDelimiter 分隔符（逗号）
     * @return
     */
    private static String toIntArrayString(int[] array, String[] surrounds, String joinDelimiter) {
        return surrounds[0] + String.join(joinDelimiter, Arrays.stream(array).mapToObj(Convert::toString).toArray(String[]::new)) + surrounds[1];
    }

    /**
     * 将stream流中的元素组装为字符串
     *
     * @param stream        包装类型数组的流序列
     * @param surrounds     前后缀（括号）
     * @param joinDelimiter 分隔符（逗号）
     * @return
     */
    private static String toObjectArrayString(Stream<?> stream, String[] surrounds, String joinDelimiter) {
        return surrounds[0] + stream.map(Convert::toString).collect(Collectors.joining(joinDelimiter)) + surrounds[1];
    }

    /**
     * 转换为布尔值
     *
     * @param o
     * @return null时返回false
     */
    public static Boolean toBoolean(Object o) {
        if (null == o) {
            return false;
        }
        return Boolean.parseBoolean(toString(o));
    }

    /**
     * 转换为整数
     *
     * @param o
     * @return o的整数值，null时返回0
     */
    public static Integer toInteger(Object o) {
        if (null == o) {
            return 0;
        }
        return Integer.parseInt(toString(o));
    }
}
