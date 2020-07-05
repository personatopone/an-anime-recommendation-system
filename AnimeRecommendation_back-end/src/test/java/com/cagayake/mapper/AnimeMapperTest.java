package com.cagayake.mapper;

import com.cagayake.bean.Anime;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AnimeMapperTest {

    private static Logger logger = Logger.getLogger(AnimeMapperTest.class);
    @Autowired
    private AnimeMapper mapper;
    private Anime anime;
    @Test
    void test(){
        anime = new Anime();
        anime.setSeason_name("spring");
        anime.setSeason_year("2013");
        anime.setMal_id(2);
        //Because it is an insertion test, if you want to repeat the test,
        //please modify the primary key or delete the record of the duplicate primary key in the database
        anime.setTitle("animeTest");
        mapper.findAnimeBySeasonAndYear(anime);
        mapper.findAnimeById(12421);
        mapper.saveAnime(anime);
        logger.info("anime mapper test passed");
        anime.setScore("0");
        mapper.updateAnime(anime);
        logger.info("anime mapper update function test passed");
    }
}
