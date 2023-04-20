package com.hong.call.ccus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 资源描述
 *
 * @author leon
 * @date 2023/4/17
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CcusUrl {
    
    String url();

    String name() default "";

    /**
     * 不是文档head中的type
     * @author leon
     * @date 2023/4/17 17:55
     * @param
     * @return
     */
    String type();

    Class returnClazz();

    boolean NullFlag() default false;
}
