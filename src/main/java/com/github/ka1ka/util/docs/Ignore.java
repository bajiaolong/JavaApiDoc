package com.github.ka1ka.util.docs;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Ignore Field
 * @author yeguozhong util.github.com
 */
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.METHOD})
public @interface Ignore {
}
