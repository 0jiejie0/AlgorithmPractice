package main.customUtil;

import java.lang.annotation.*;

/**
 * 测试框架-测试用例容器
 *
 * @author O
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AssertExamples {
    AssertExample[] value();
}
