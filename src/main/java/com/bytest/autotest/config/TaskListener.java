package com.bytest.autotest.config;

import com.bytest.autotest.dto.CreditEvent;
import com.bytest.autotest.flow.ProcessFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * <h3>risk-auto-test</h3>
 * <p>授信业务监听</p>
 *
 * @author : hh
 * @date : 2020-09-11 14:44
 **/
@Component
public class TaskListener implements ApplicationListener<CreditEvent> {

    @Autowired
    ProcessFlow processFlow;


    /**通过注解自定位事件监听：@EventListener
     * public void myListener(MyEvent event){
     *     .....
     * }
     *
     * @param creditEvent
     *
     * 监听授信完成，开始执行借款业务
     */
    @Override
    public void onApplicationEvent(CreditEvent creditEvent) {
        Map<String,String> map = creditEvent.getMap();
        processFlow.excuteLoan(map);

    }
}
