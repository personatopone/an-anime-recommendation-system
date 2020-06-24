package com.cagayake.utils;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class JWTUtilTest {

    private static Logger logger = Logger.getLogger(JWTUtilTest.class);
    private static String token;


    @BeforeAll
    static void initial() {
        token = JWTUtil.sign("admin", "123456");

    }

    @Test
    void testTokenSign() {
        String myToken = JWTUtil.sign("admin", "123456");
        logger.info("the token is "+myToken);
        logger.info("JWTUtil token sign test passed");
    }

    @Test
    void testTokenVerify() {
        Assertions.assertTrue(JWTUtil.verify(token, "admin", "123456"));

        Assertions.assertFalse(JWTUtil.verify(token, "admin", "1234567"));

        Assertions.assertFalse(JWTUtil.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1ODg2MTI2NjIsInVzZXJuYW1lIjoiYWRtaW4ifQ.ZcbdOc8utYGQg70ZBiM9zp4h7tk8sU6dPHNGE89U1Js", "admin", "1234567"));

        logger.info("JWTUtil token verify test passed");
    }

    @Test
    void testGetUsername() {
        Assertions.assertEquals("admin", JWTUtil.getUsername(token));
        logger.info("JWTUtil Get username verify test passed");
    }
}
