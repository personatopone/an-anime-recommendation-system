package com.cagayake.api;

import com.cagayake.dataSave.DataSave;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AnimeRecommendationApplicationTests {

    @Autowired
   private DataSave dataSave;

    @Test
    void contextLoads() {
        dataSave.saveSeasonAnime(2019,2020);
    }

}
