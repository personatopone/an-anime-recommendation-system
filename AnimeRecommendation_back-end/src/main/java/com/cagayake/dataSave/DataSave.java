package com.cagayake.dataSave;

import com.cagayake.bean.Anime;
import com.cagayake.dataSave.JsonBean.SeasonJsonList;
import com.cagayake.mapper.AnimeMapper;
import com.cagayake.utils.RequestUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataSave {

   private Gson gson;
   private AnimeMapper animeMapper ;

    public DataSave(){
        gson = new Gson();
    }

    public void saveSeasonAnime(int startYear,int endYear) {

        String[] seasons = {"spring","summer","fall","winter"};

        while (startYear<=endYear){
            for (String season:seasons) {
                String json = RequestUtil.sendGet("https://api.jikan.moe/v3/season/"+startYear+"/"+season);
                SeasonJsonList SeasonAnime = gson.fromJson(json,SeasonJsonList.class);
                for (Anime anime:SeasonAnime.getAnime()) {

                    if (animeMapper.findAnimeById(anime.getMal_id()).size()==0){
                        anime.setSeason_name(SeasonAnime.getSeason_name());
                        anime.setSeason_year(SeasonAnime.getSeason_year());
                        animeMapper.saveAnime(anime);
                    }
                    else{
                        System.out.println("It already exists.");
                        continue;
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

    @Autowired
    public void setAnimeMapper(AnimeMapper animeMapper) {
        this.animeMapper = animeMapper;

    }

}



