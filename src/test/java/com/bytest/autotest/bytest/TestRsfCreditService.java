package com.bytest.autotest.bytest;

import com.bytest.autotest.domain.TrxApplyInfo;
import com.bytest.autotest.innerService.TrxApplyInfoService;
import com.byxf.rfs.api.dto.crs.RfsCreditApplyResultDto;
import com.byxf.rfs.api.service.CreditService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * <h3>risk-auto-test</h3>
 * <p>测试风险前置查询授信接口</p>
 *
 * @author : hh
 * @date : 2020-08-27 10:02
 **/
@Slf4j
@SpringBootTest
public class TestRsfCreditService {
    @Autowired
    CreditService creditService;
    @Autowired
    TrxApplyInfoService trxApplyInfoService;

    @Test
    public void testRsfCreditService(){

       // List<TrxApplyInfo> list = trxApplyInfoService.queryAllByLimit(1,10);
        RfsCreditApplyResultDto rfsCreditApplyResultDto=creditService.queryCreditResultByApplyNo("C372208280015460008");
       // TrxApplyInfo trxApplyInfo = trxApplyInfoService.queryById("C522008040014130006");
       // log.info("ddddddddddddddddddddd");
        log.info("接口返回的对象》》》》》》:{}",rfsCreditApplyResultDto);
       // log.info("测试数据对象》》》》{}",trxApplyInfo);
    }
}
