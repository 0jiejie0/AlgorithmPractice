package main.customUtil;

/**
 * （主要在做算法代码测试时应用）
 * 将字符串和一定数据格式类型做格式化转换
 */
public class Format {
    //采用链式调用的结构
    private static String prefix;//前缀
    private static String suffix;//后缀
    private static String separator;//分隔符
    private static Format instance;//该实例无实际内容，仅为方便链式调用的类结构

    static {
        prefix = "[";//前后缀默认[]
        suffix = "]";
        separator = ",";//分隔符默认为","
    }

    public static Format getInstance() {
        if (instance == null) {
            instance = new Format();
        }
        return instance;
    }

    public static Format setPrefixAndSuffix(String prefixAndSuffix) {
        setPrefix(prefixAndSuffix.substring(0, prefixAndSuffix.length() >> 1));
        setSuffix(prefixAndSuffix.substring(prefixAndSuffix.length() >> 1));
        return getInstance();
    }

    public static Format setPrefix(String prefix) {
        Format.prefix = prefix;
        return getInstance();
    }

    public static Format setSuffix(String suffix) {
        Format.suffix = suffix;
        return getInstance();
    }

    public static Format setSeparator(String separator) {
        Format.separator = separator;
        return getInstance();
    }

    public static final int[] arrayInt(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        stringBuilder.delete(0, prefix.length());
//        stringBuilder.;
        setPrefixAndSuffix("[]");
        setSeparator(",");
        return null;
    }
}
