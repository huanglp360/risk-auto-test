package com.bytest.autotest.aspect;

import com.bytest.autotest.enums.DateSourceType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <h3>risk-auto-test</h3>
 * <p></p>
 *
 * @author : hh
 * @date : 2020-08-17 20:35
 **/

@Target({ElementType.PARAMETER, ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DynamicSource {
    DateSourceType dasource() default DateSourceType.bre;
}
