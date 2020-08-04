package com.shubao.sell.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WechatMpConfigTest {

    @Autowired
    private WechatMpConfig wechatMpConfig;

    @Test
    public void wxMpService() {
        System.out.println("begin...");
        wechatMpConfig.wxMpService();
        System.out.println("end....");
    }

    @Test
    public void wxMpConfigStorage() {
    }
}