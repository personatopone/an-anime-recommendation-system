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

    public static int TITLE = 0;
    public static int GENRE =1;
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

    @Override
    public List<Anime> RankingAnime() {
        return animeMapper.findAnimeByClickCount().subList(0,50);
    }

    @Override
    public List<Anime> findAnime(int searchType, String content) {
        List<Anime> animeList;
        switch (searchType){
            case 0:
                animeList= animeMapper.findAnimeByTitle(content);
                break;
            case 1:
                animeList = animeMapper.findAnimeByGenre(content);
                break;
            default:
                animeList = null;
        }
        return animeList;
    }

    @Autowired
    public void setAnimeMapper(AnimeMapper animeMapper) {
        this.animeMapper = animeMapper;
    }
}
