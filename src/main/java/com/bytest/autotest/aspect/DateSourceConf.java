package com.bytest.autotest.aspect;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.bytest.autotest.enums.DateSourceType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


/**
 * <h3>risk-auto-test</h3>
 * <p>数据源配置类</p>
 *
 * @author : hh
 * @date : 2020-08-17 19:14
 **/
@Configuration
public class DateSourceConf implements EnvironmentAware {

    @Autowired
    private Environment env;

    @Override
    public void setEnvironment(Environment environment) {
        this.env = environment;
    }

    @Bean(name = "vppDataSource")
    public DataSource vppDataSource() throws Exception {
        Properties per = new Properties();
        per.put("url",env.getProperty("vpp.jdbc.url"));
        per.put("username",env.getProperty("vpp.username"));
        per.put("password",env.getProperty("vpp.password"));
        per.put("driver-class-name",env.getProperty("vpp.driverClassName"));
        per.put("filters",env.getProperty("jdbc.filters"));
        per.put("maxActive",env.getProperty("jdbc.maxActive"));
        per.put("initialSize",env.getProperty("jdbc.initialSize"));
        per.put("maxWait",env.getProperty("jdbc.maxWait"));
        per.put("validationQuery",env.getProperty("jdbc.validationQuery"));
        per.put("poolPreparedStatements",env.getProperty("jdbc.poolPreparedStatements"));
        per.put("maxOpenPreparedStatements",env.getProperty("jdbc.maxOpenPreparedStatements"));
        return DruidDataSourceFactory.createDataSource(per);
    }
    @Bean(name = "breDataSource")
    public DataSource breDataSource() throws Exception {
        Properties per = new Properties();
        per.put("url",env.getProperty("bre.jdbc.url"));
        per.put("username",env.getProperty("vpp.username"));
        per.put("password",env.getProperty("vpp.password"));
        per.put("driver-class-name",env.getProperty("vpp.driverClassName"));
        per.put("filters",env.getProperty("jdbc.filters"));
        per.put("maxActive",env.getProperty("jdbc.maxActive"));
        per.put("initialSize",env.getProperty("jdbc.initialSize"));
        per.put("maxWait",env.getProperty("jdbc.maxWait"));
        per.put("validationQuery",env.getProperty("jdbc.validationQuery"));
        per.put("poolPreparedStatements",env.getProperty("jdbc.poolPreparedStatements"));
        per.put("maxOpenPreparedStatements",env.getProperty("jdbc.maxOpenPreparedStatements"));
        return DruidDataSourceFactory.createDataSource(per);

    }
    @Bean(name = "rmsDataSource")
    public DataSource rmsDataSource() throws Exception {
        Properties per = new Properties();
        per.put("url",env.getProperty("rms.jdbc.url"));
        per.put("username",env.getProperty("vpp.username"));
        per.put("password",env.getProperty("vpp.password"));
        per.put("driver-class-name",env.getProperty("vpp.driverClassName"));
        per.put("filters",env.getProperty("jdbc.filters"));
        per.put("maxActive",env.getProperty("jdbc.maxActive"));
        per.put("initialSize",env.getProperty("jdbc.initialSize"));
        per.put("maxWait",env.getProperty("jdbc.maxWait"));
        per.put("validationQuery",env.getProperty("jdbc.validationQuery"));
        per.put("poolPreparedStatements",env.getProperty("jdbc.poolPreparedStatements"));
        per.put("maxOpenPreparedStatements",env.getProperty("jdbc.maxOpenPreparedStatements"));
        return DruidDataSourceFactory.createDataSource(per);

    }
    @Bean(name = "crsDataSource")
    public DataSource crsDataSource() throws Exception {
        Properties per = new Properties();
        per.put("url",env.getProperty("crs.jdbc.url"));
        per.put("username",env.getProperty("vpp.username"));
        per.put("password",env.getProperty("vpp.password"));
        per.put("driver-class-name",env.getProperty("vpp.driverClassName"));
        per.put("filters",env.getProperty("jdbc.filters"));
        per.put("maxActive",env.getProperty("jdbc.maxActive"));
        per.put("initialSize",env.getProperty("jdbc.initialSize"));
        per.put("maxWait",env.getProperty("jdbc.maxWait"));
        per.put("validationQuery",env.getProperty("jdbc.validationQuery"));
        per.put("poolPreparedStatements",env.getProperty("jdbc.poolPreparedStatements"));
        per.put("maxOpenPreparedStatements",env.getProperty("jdbc.maxOpenPreparedStatements"));
        return DruidDataSourceFactory.createDataSource(per);

    }
    @Bean(name = "dcpDataSource")
    public DataSource dcpDataSource() throws Exception {
        Properties per = new Properties();
        per.put("url",env.getProperty("dcp.jdbc.url"));
        per.put("username",env.getProperty("vpp.username"));
        per.put("password",env.getProperty("vpp.password"));
        per.put("driver-class-name",env.getProperty("vpp.driverClassName"));
        per.put("filters",env.getProperty("jdbc.filters"));
        per.put("maxActive",env.getProperty("jdbc.maxActive"));
        per.put("initialSize",env.getProperty("jdbc.initialSize"));
        per.put("maxWait",env.getProperty("jdbc.maxWait"));
        per.put("validationQuery",env.getProperty("jdbc.validationQuery"));
        per.put("poolPreparedStatements",env.getProperty("jdbc.poolPreparedStatements"));
        per.put("maxOpenPreparedStatements",env.getProperty("jdbc.maxOpenPreparedStatements"));
        return DruidDataSourceFactory.createDataSource(per);
    }
    @Bean(name = "autotestDataSource")
    public DataSource autotestDataSource() throws Exception {
        Properties per = new Properties();
        per.put("url",env.getProperty("autotest.jdbc.url"));
        per.put("username",env.getProperty("vpp.username"));
        per.put("password",env.getProperty("vpp.password"));
        per.put("driver-class-name",env.getProperty("vpp.driverClassName"));
        per.put("filters",env.getProperty("jdbc.filters"));
        per.put("maxActive",env.getProperty("jdbc.maxActive"));
        per.put("initialSize",env.getProperty("jdbc.initialSize"));
        per.put("maxWait",env.getProperty("jdbc.maxWait"));
        per.put("validationQuery",env.getProperty("jdbc.validationQuery"));
        per.put("poolPreparedStatements",env.getProperty("jdbc.poolPreparedStatements"));
        per.put("maxOpenPreparedStatements",env.getProperty("jdbc.maxOpenPreparedStatements"));
        return DruidDataSourceFactory.createDataSource(per);
    }

    @Bean("dynamicDataSource")
    public DynamicDataSource dynamicDataSource(@Qualifier("autotestDataSource") DataSource autotestDataSource,
                                               @Qualifier("dcpDataSource") DataSource dcpDataSource,
                                               @Qualifier("vppDataSource") DataSource vppDataSource,
                                               @Qualifier("rmsDataSource") DataSource rmsDataSource,
                                               @Qualifier("crsDataSource") DataSource crsDataSource,
                                               @Qualifier("breDataSource") DataSource breDataSource){
        Map<Object,Object> map = new HashMap<Object,Object>();
        map.put(DateSourceType.autotest,autotestDataSource);
        map.put(DateSourceType.dcp,dcpDataSource);
        map.put(DateSourceType.vpp,vppDataSource);
        map.put(DateSourceType.crs,crsDataSource);
        map.put(DateSourceType.rms,rmsDataSource);
        map.put(DateSourceType.bre,breDataSource);
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setTargetDataSources(map);
        dynamicDataSource.setDefaultTargetDataSource(autotestDataSource);
        return dynamicDataSource;
    }

    @Bean
    @Primary
    public SqlSessionFactory autotestSqlFactory(@Qualifier("autotestDataSource")DataSource autotestDataSource) throws Exception {
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setTypeAliasesPackage("com.bytest.autotest.domain");
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/*.xml"));
        fb.setDataSource(autotestDataSource);
        return fb.getObject();
    }
    @Bean
    public SqlSessionFactory vppSqlFactory(@Qualifier("vppDataSource")DataSource vppDataSource) throws Exception {
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setTypeAliasesPackage("com.bytest.autotest.domain");
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/*.xml"));
        fb.setDataSource(vppDataSource);
        return fb.getObject();
    }
    @Bean
    public SqlSessionFactory dcpSqlFactory(@Qualifier("dcpDataSource")DataSource dcpDataSource) throws Exception {
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setTypeAliasesPackage("com.bytest.autotest.domain");
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/*.xml"));
        fb.setDataSource(dcpDataSource);
        return fb.getObject();
    }
    @Bean
    public SqlSessionFactory breSqlFactory(@Qualifier("breDataSource")DataSource breDataSource) throws Exception {
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setTypeAliasesPackage("com.bytest.autotest.domain");
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/*.xml"));
        fb.setDataSource(breDataSource);
        return fb.getObject();
    }
    @Bean
    public SqlSessionFactory crsSqlFactory(@Qualifier("crsDataSource")DataSource crsDataSource) throws Exception {
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setTypeAliasesPackage("com.bytest.autotest.domain");
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/*.xml"));
        fb.setDataSource(crsDataSource);
        return fb.getObject();
    }
    @Bean
    public SqlSessionFactory rmsSqlFactory(@Qualifier("rmsDataSource")DataSource rmsDataSource) throws Exception {
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setTypeAliasesPackage("com.bytest.autotest.domain");
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/*.xml"));
        fb.setDataSource(rmsDataSource);
        return fb.getObject();
    }


}
