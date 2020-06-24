package com.cagayake.service;

import com.cagayake.bean.Anime;
import com.cagayake.service.homepage.HomePageService;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class HomeServiceTest {

    private static Logger logger = Logger.getLogger(HomeServiceTest.class);
    @Autowired
    private HomePageService service;

    @Test
    void testHomepageService() {
        List<Anime> animeList1 = service.animeList("2010", "spring");
        Assertions.assertNull(service.animeList("2001", "spring"));
        Assertions.assertNull(service.animeList("a", "a"));
        Assertions.assertNull(service.animeList("a", "spring"));
        Assertions.assertNull(service.animeList("2020", "a"));
        logger.info("HomePageService test passed");

    }
}
