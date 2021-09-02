package com.easy.tool.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 高俊
 * @create 2021-09-2021/9/2-11:24
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ToJsonIgnore {
    boolean require() default false;

    int[] group() default {0};
}
