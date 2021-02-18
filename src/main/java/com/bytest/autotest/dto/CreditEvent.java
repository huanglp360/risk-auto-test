package com.bytest.autotest.dto;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

import java.io.Serializable;
import java.util.Map;

/**
 * <h3>risk-auto-test</h3>
 * <p>授信事件</p>
 *
 * @author : hh
 * @date : 2020-09-11 14:36
 **/
public class CreditEvent extends ApplicationEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    public CreditEvent(Object source, Map<String,String> map) {
        super(source);
        this.map = map;
    }

    public Map<String,String> map;

    public Map<String,String> getMap(){
        return map;
    }

    public void setMap(Map<String,String> map){
        this.map = map;
    }
}
