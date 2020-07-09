package main.customUtil;

/**
 * 设置对一定数据结构的输出，以减少后续代码量
 */
public class Print {
    /**
     * 将给定数组前后附入前后缀，用给定分隔符分隔各个元素输出
     *
     * @param arr       要输出的数组
     * @param prefix    前缀
     * @param suffix    后缀
     * @param separator 分隔符
     */
    public static final void arrayWithPrefixAndSuffix(Object[] arr, String prefix, String suffix, String separator) {

        System.out.print(prefix);
        for (int i = 0; i < arr.length; i++) {
            System.out.print((i != 0 ? separator : "") + arr[i].toString());
        }
        System.out.println(suffix);
    }

    /**
     * 将给定数组前后附入前后缀，用英文逗号“,”分隔各个元素输出
     *
     * @param arr    要输出的数组
     * @param prefix 前缀
     * @param suffix 后缀
     */
    public static final void arrayWithPrefixAndSuffix(Object[] arr, String prefix, String suffix) {
        arrayWithPrefixAndSuffix(arr, prefix, suffix, ", ");
    }

    /**
     * 将给定数组前后附入前后缀，用英文逗号“,”分隔各个元素输出
     * 接收的前后缀拼接到一个字符串，从中间分割为前后两部分作为前后缀
     *
     * @param arr             要输出的数组
     * @param prefixAndSuffix 前后缀
     */
    public static final void arrayWithPrefixAndSuffix(Object[] arr, String prefixAndSuffix) {
        if (prefixAndSuffix == null) {
            prefixAndSuffix = "";
        }
        arrayWithPrefixAndSuffix(arr,
                prefixAndSuffix.substring(0, prefixAndSuffix.length() >> 1),
                prefixAndSuffix.substring(prefixAndSuffix.length() >> 1));
    }

    /**
     * 定义标准输出：将给定数组以方括号为前后缀，英文逗号“,”分隔各个元素输出
     *
     * @param arr
     */
    public static final void arrayStandard(Object[] arr) {
        arrayWithPrefixAndSuffix(arr, "[]");
    }

    /**
     * 将int数组转化为Object数组标准化输出
     *
     * @param arr
     */
    public static final void arrayStandard(int[] arr) {
        Integer[] integers = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            integers[i] = arr[i];
        }
        arrayStandard(integers);
    }

    /**
     * 将给定数组以花括号为前后缀，英文逗号“,”分隔各个元素输出
     *
     * @param arr
     */
    public static final void arrayWithBraces(Object[] arr) {
        arrayWithPrefixAndSuffix(arr, "{}");
    }
}
