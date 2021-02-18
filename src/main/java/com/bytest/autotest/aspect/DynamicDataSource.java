package com.bytest.autotest.aspect;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * <h3>risk-auto-test</h3>
 * <p>动态获取数据源</p>
 *
 * @author : hh
 * @date : 2020-08-17 19:11
 **/
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceHolder.getType();
    }
}
