package com.cagayake.mapper;

import com.cagayake.bean.Anime;
import com.cagayake.utils.JWTUtilTest;
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
        anime.setTitle("animeTest");
        mapper.findAnimeBySeasonAndYear(anime);
        mapper.findAnimeById(12421);
        mapper.saveAnime(anime);
        logger.info("anime mapper test passed");
    }
}
