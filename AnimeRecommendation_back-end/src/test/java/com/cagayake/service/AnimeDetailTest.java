package com.cagayake.service;

import com.cagayake.bean.Comment;
import com.cagayake.service.AnimeDetail.AnimeDetailService;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AnimeDetailTest {

    private static Logger logger = Logger.getLogger(HomeServiceTest.class);

    @Autowired
    private  AnimeDetailService animeDetailService;

    @Test
    void Test(){

        animeDetailService.saveComment(new Comment(1,"a","a","a"));
        animeDetailService.findComment(1);
        animeDetailService.findAnime(1);
        animeDetailService.findSong(777,"op");
        logger.info("AnimeDetailService test passed");

    }
}
