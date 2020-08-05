package com.shubao.sell;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
//方式二
@Slf4j
//@Data
public class LoggerTest {

//    方式一
//    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test1(){
//        方式一
//        logger.debug("debug...");
//        logger.info("info...");
//        logger.error("error...");

        String username = "root";
        String password = "123456";

//        方式二
        log.debug("debug...");
        log.info("info...");
        log.error("error...");

        log.info("username:" + username + ", password:" + password);
        log.info("username:{}, password:{}", username, password);
    }
}
