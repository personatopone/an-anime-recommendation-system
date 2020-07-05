package com.cagayake.dataSave;

import com.cagayake.bean.Anime;
import com.cagayake.bean.Genre;
import com.cagayake.bean.Song;
import com.cagayake.dataSave.JsonBean.AnimeDetailJson;
import com.cagayake.dataSave.JsonBean.SeasonJsonList;
import com.cagayake.mapper.AnimeMapper;
import com.cagayake.mapper.GenreMapper;
import com.cagayake.mapper.SongMapper;
import com.cagayake.utils.RequestUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataSave {

   private Gson gson;
   private AnimeMapper animeMapper ;
   private SongMapper songMapper;
   private GenreMapper genreMapper;

    public DataSave(){
        gson = new Gson();
    }


    /**
     * 添加从2010到2020的anime到数据库
     */
    public void saveSeasonAnime() {

        int startYear = 2010;
        int endYear = 2020;
        String[] seasons = {"spring","summer","fall","winter"};

        while (startYear<=endYear){
            for (String season:seasons) {
                String json = RequestUtil.sendGet("https://api.jikan.moe/v3/season/"+startYear+"/"+season);
                SeasonJsonList SeasonAnime = gson.fromJson(json,SeasonJsonList.class);
                for (Anime anime:SeasonAnime.getAnime()) {

                    if (animeMapper.findAnimeById(anime.getMal_id())!=null){
                        anime.setSeason_name(SeasonAnime.getSeason_name());
                        anime.setSeason_year(SeasonAnime.getSeason_year());
                        animeMapper.saveAnime(anime);
                    }
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            startYear++;
        }
    }

    /**
     * 添加动画的其他信息到数据库
     */
    public void saveAnimeDetail(){

        List<Anime> allAnime = animeMapper.findALl();
        for (Anime anime:allAnime.subList(6910,allAnime.size()) ){
            String json = RequestUtil.sendGet("https://api.jikan.moe/v3/anime/"+anime.getMal_id());
            AnimeDetailJson detailJson = gson.fromJson(json,AnimeDetailJson.class);
            anime.setScore(detailJson.getScore());
            anime.setTitle_japanese(detailJson.getTitle_japanese());
            anime.setClick_conut(0);
            animeMapper.updateAnime(anime);
            for (Genre genre :detailJson.getGenres()){
                genre.setMal_id(anime.getMal_id());
                genreMapper.saveGenre(genre);
            }
            for (String op:detailJson.getEnding_themes()){
                Song song = new Song(anime.getMal_id(),"op",op);
                songMapper.saveSong(song);
            }

            for (String ed:detailJson.getEnding_themes()){
                Song song = new Song(anime.getMal_id(),"ed",ed);
                songMapper.saveSong(song);
            }

           try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(allAnime.indexOf(anime)+"已经抓取,还剩下："+(allAnime.size()-allAnime.indexOf(anime)));
        }
    }

    @Autowired
    public void setAnimeMapper(AnimeMapper animeMapper) {
        this.animeMapper = animeMapper;

    }
    @Autowired
    public void setSongMapper(SongMapper songMapper) {
        this.songMapper = songMapper;
    }
    @Autowired
    public void setGenreMapper(GenreMapper genreMapper) {
        this.genreMapper = genreMapper;
    }
}



