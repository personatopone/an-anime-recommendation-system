package com.cagayake.utils;


import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RequestUtilTest {

    private static Logger logger = Logger.getLogger(RequestUtilTest.class);

    @Test
    void testRequest(){
        RequestUtil.sendGet("https://www.baidu.com");
        logger.info("RequestUtil test passed");
    }
}
