package com.bytest.autotest.aspect;

import com.bytest.autotest.enums.DateSourceType;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * <h3>risk-auto-test</h3>
 * <p>数据源切换</p>
 *
 * @author : hh
 * @date : 2020-08-17 18:54
 **/
@Slf4j
@Aspect
@Component
public class DataSourceAspect {
    @Pointcut("execution(* com.bytest.autotest.innerService.*.*(..))")
    public void datasourcePointCut(){

    }

    @Before("datasourcePointCut()")
    public void before(JoinPoint joinPoint) throws ClassNotFoundException {
        String clazzname = joinPoint.getTarget().getClass().getName();
        Class target =Class.forName(clazzname);
        DynamicSource a = (DynamicSource)target.getAnnotation(DynamicSource.class);
        if (a==null){
            DataSourceHolder.setDatSouceType(DateSourceType.autotest);
            log.info("切换数据源为{}",DateSourceType.autotest);
        }else {
            DataSourceHolder.setDatSouceType(a.dasource());
            log.info("切换数据源为：{},类名为：{}",a,clazzname);
        }
    }

}
