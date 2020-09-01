package com.bytest.autotest.config;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * <h3>risk-auto-test</h3>
 * <p>获取服务http地址</p>
 *
 * @author : hh
 * @date : 2020-05-19 17:02
 **/
@Component
public class ServerConfig  implements ApplicationListener<WebServerInitializedEvent> {

    private int serverPort;

    public String getUrl(){
        InetAddress address =null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "http://"+address.getHostAddress()+":"+this.serverPort+"/";
    }
    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        this.serverPort = event.getWebServer().getPort();
    }
}
