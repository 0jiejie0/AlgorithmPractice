package main.customUtil;

import main.Main;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;

/**
 * 从类所在包扫描所有子目录文件对象，筛选class文件，把所有class文件转成class对象，对象中方法标明注解条件的，将class对象组装从一个List列表
 *
 * @author O
 */
public class Loader {
    // todo: 为方便层层调用时少些点参数和返回值，将类文件列表定义为全局变量，若多次加载文件，需要重新调整其结构
    private static List<File> classFileList = new ArrayList<>();

    // 项目根目录包名
    private static String rootPackageName = "main";

    // 扫描标记，控制是否扫描主类包下和主类同级的类文件的
    private static boolean scanMainPackageClass = false;

    /**
     * 将文件列表中的文件对象转化为 class 对象，筛选后添加到 class 列表
     *
     * @param annotations 要满足的注解条件（标明此注解的才会添加到 class 对象列表）
     * @return
     * @throws Exception 底层传递，获取 Class 对象异常
     */
    public static List<Class<?>> getClasses(Class<? extends Annotation>[] annotations) throws Exception {
        List<Class<?>> classList = new ArrayList<>();
        for (File file : classFileList) {
            Class<?> convertedClass = getClass(file.getPath());
            for (Method declaredMethod : convertedClass.getDeclaredMethods()) {
                boolean needAdd = false;  // 辅助跳出两层循环，防止同一个类两次加入列表
                for (Class<? extends Annotation> annotation : annotations) { // 多注解筛选，只要方法标明列表其一注解，就需要其类添加到类列表（筛选需要运行的类）
                    if (declaredMethod.isAnnotationPresent(annotation)) {
                        needAdd = true;
                        break;
                    }
                }
                if (needAdd) {
                    classList.add(convertedClass);
                    break;
//                } else {
//                    System.out.println("pass " + convertedClass.getName() + declaredMethod.getName());  // 不满足注解条件的类
                }
            }
        }
        return classList;
    }

    /**
     * 获取指定文件路径对应的 Class 对象
     *
     * @param filePath 文件路径
     * @return Class 对象
     * @throws Exception 获取 Class 对象异常
     */
    public static Class<?> getClass(String filePath) throws Exception {
        String className = filePath.substring(filePath.indexOf(rootPackageName))
                .replaceAll("\\\\", ".")
                .replaceAll("\\.class", "");
        return Class.forName(className);
    }

    /**
     * 默认从主类所在包开始扫描class文件
     *
     * @throws Exception 获取资源路径时IO错误，或找不到对应包资源
     */
    public static void loadClassFiles() throws Exception {
        loadClassFiles(Main.class);
    }

    /**
     * 从指定类所在包开始，扫描class文件
     * <p>
     * 获取包资源路径
     *
     * @param cls 要扫描的包中类的Class对象
     * @throws Exception 获取资源路径时IO错误，或找不到对应包资源
     */
    public static void loadClassFiles(Class<?> cls) throws Exception {
        Enumeration<URL> resources = Thread.currentThread().getContextClassLoader().getResources(cls.getPackage().getName());
        if (!resources.hasMoreElements()) {
            throw new Exception("找不到包，请检查后重试");
        }
        loadClassFiles(resources.nextElement().getFile());  // 正常来说对应包只有一个，所有只需要获取一次资源路径就够了
    }

    /**
     * 从指定资源路径扫描class文件，借扫描标记筛选 参数路径下第一级类文件，调用实现添加类文件到列表
     *
     * @param pkgResourcePathName 扫描文件的起始包资源路径
     */
    public static void loadClassFiles(String pkgResourcePathName) {
        File pkg = new File(pkgResourcePathName);
        // 利用静态标记控制扫描参数路径包下第一级类文件
        for (File listFile : Objects.requireNonNull(pkg.listFiles(pathname -> scanMainPackageClass || !pathname.isFile()))) {
            loadClassFiles(listFile);
        }
    }

    /**
     * 递归扫描给定目录及目录下所有类文件，添加到静态列表
     *
     * @param file 要扫描的对象，实质为目录或文件
     */
    public static void loadClassFiles(File file) {
        if (file.isFile()) {  // class 文件直接添加到列表
            if (file.getName().endsWith(".class")) {
                classFileList.add(file);
            }
            return;
        }
        for (File listFile : Objects.requireNonNull(file.listFiles())) {
            loadClassFiles(listFile);
        }
    }
}
