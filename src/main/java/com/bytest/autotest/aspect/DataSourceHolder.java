package com.bytest.autotest.aspect;

import com.bytest.autotest.enums.DateSourceType;

/**
 * <h3>risk-auto-test</h3>
 * <p>创建获取数据库工具</p>
 *
 * @author : hh
 * @date : 2020-08-17 19:05
 **/
public class DataSourceHolder  {
    public static final ThreadLocal<DateSourceType> thread = new ThreadLocal<>();

    public static void setDatSouceType(DateSourceType type){
        thread.set(type);
    }

    public static DateSourceType getType(){
        return thread.get();
    }

    public static void remove(DateSourceType type){
        thread.remove();
    }

}
