package com.cagayake.mapper;

import com.cagayake.bean.Anime;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper()
@Repository()
public interface AnimeMapper {
    void saveAnime(Anime anime);
    List<Anime> findAnimeById(int id);
    List<Anime> findAnimeBySeasonAndYear(Anime anime);
    List<Anime> findALl();
    void updateAnime(Anime anime);
}
