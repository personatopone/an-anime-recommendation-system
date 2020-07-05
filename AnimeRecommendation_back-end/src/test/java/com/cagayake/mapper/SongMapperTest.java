package com.cagayake.mapper;

import com.cagayake.bean.Song;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class SongMapperTest {

    private static Logger logger = Logger.getLogger(SongMapperTest.class);
    @Autowired
   private SongMapper songMapper;

    @Test
    void Test(){
        songMapper.saveSong(new Song(1,"op","a"));
        Song song = new Song(1,"op","a");

        Assert.isTrue( songMapper.findSongByIdAndType(song).get(0).getName().equals("a"),"song Mapper");
        logger.info("Song mapper test passed");
    }
}
