package com.cagayake.mapper;

import com.cagayake.bean.Song;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper()
@Repository()
public interface SongMapper {
    void saveSong(Song song);
}
