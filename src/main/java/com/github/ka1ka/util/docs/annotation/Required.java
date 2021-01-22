package com.github.ka1ka.util.docs.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 必须
 *
 * @author 05697-LongLiHua
 * @version Id: Required.java, v 0.1 2021/1/20 17:42  LongLiHua Exp $
 * @Description
 */
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.METHOD})
public @interface Required {
    /**
     * 方法名 支持多个 用逗号隔开
     *
     * @param
     * @return java.lang.String
     **/
    String[] methodName() default {};
}
