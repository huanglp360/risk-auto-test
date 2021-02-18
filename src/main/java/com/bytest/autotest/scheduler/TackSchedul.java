package com.bytest.autotest.scheduler;

import com.bytest.autotest.domain.TrxApplyInfo;
import com.bytest.autotest.dto.CreditEvent;
import com.bytest.autotest.innerService.TrxApplyInfoService;
import com.bytest.autotest.redis.RedisTool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 * <h3>risk-auto-test</h3>
 * <p>扫描案例执行是否完成</p>
 *
 * @author : hh
 * @date : 2020-09-09 16:42
 **/
@Configuration
@EnableScheduling
@Slf4j
public class TackSchedul {
    @Autowired
    private TrxApplyInfoService trxApplyInfoService;

    @Autowired
    private RedisTool redisTool;

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * 每5分钟执行一次
     */
    @Scheduled(cron = "0 0/2 * * * ? ")
    private void starLoan(){

        log.info("开始读取redis存储的授信案件号案件号");
        Map<String,String> map =redisTool.hmget("auto_test_applyno_key");
        log.info("开始读取redis存储的授信案件号案件号{}",map);
        List<TrxApplyInfo> list = trxApplyInfoService.queryNoFinish(map);
        //发布事件授信完成时间，开始借款
       if (!CollectionUtils.isEmpty(list)){
           CreditEvent event = new CreditEvent(this, map);
           log.info("开始执行借款案件{}",event.getMap());
           applicationContext.publishEvent(event);
           }
    }






}
