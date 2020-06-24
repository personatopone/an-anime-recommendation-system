package com.cagayake.dataSave;


import com.cagayake.service.HomeServiceTest;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.crypto.Data;

@SpringBootTest
public class DataSaveTest {

    private static Logger logger = Logger.getLogger(HomeServiceTest.class);
    @Autowired
    private DataSave dataSave;

    @Test
    void test(){
        dataSave.saveSeasonAnime();
        logger.info("dataSave test passed");

    }
}
