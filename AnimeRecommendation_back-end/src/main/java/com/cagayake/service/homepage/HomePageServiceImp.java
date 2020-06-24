package com.cagayake.service.homepage;

import com.cagayake.bean.Anime;
import com.cagayake.mapper.AnimeMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class HomePageServiceImp implements HomePageService {


    private AnimeMapper animeMapper;


    @Override
    public List<Anime> animeList(String year, String season) {

        Anime anime = new Anime();
        anime.setSeason_year(year);
        anime.setSeason_name(season);
        List<Anime> seasonAnimeList = animeMapper.findAnimeBySeasonAndYear(anime);
        if (seasonAnimeList.size() != 0) {
            return seasonAnimeList;
        }
        return null;
    }

    @Autowired
    public void setAnimeMapper(AnimeMapper animeMapper) {
        this.animeMapper = animeMapper;
    }
}
