package main.customUtil;

import java.lang.annotation.*;


/**
 * 测试框架-测试用例注解
 *
 * @author O
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)  // 注解保留到运行时
@Documented
@Repeatable(AssertExamples.class)  // 注明要使用哪个容器类
public @interface AssertExample {
    String[] params() default {};

    String expectResult() default "";
}
