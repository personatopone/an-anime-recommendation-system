package com.cagayake.mapper;

import com.cagayake.bean.Genre;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GenreMapperTest {
    private static Logger logger = Logger.getLogger(GenreMapperTest.class);

    @Autowired
    private GenreMapper genreMapper;

    @Test
    void test(){
        genreMapper.saveGenre(new Genre(1,"a"));
        logger.info("Genre mapper test passed");
    }

}
