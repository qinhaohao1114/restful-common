package com.restful.org.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @Author: qinhaohao
 * @Description: 是否需要token验证
 * @Date: 2017/12/28 16:20
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Permission {
    boolean useQueryToken() default true;
}
