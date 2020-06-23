package com.cagayake.dataSave;

import com.cagayake.bean.Anime;
import com.cagayake.utils.RequestUtil;
import com.google.gson.Gson;

import java.util.List;

public class DataSave {
    Gson gson;
    public DataSave(){
        gson = new Gson();
    }

    public void saveSeasonAnime(){

        String json = RequestUtil.sendGet("https://api.jikan.moe/v3/season/2018/winter");
        SeasonJsonList list = gson.fromJson(json,SeasonJsonList.class);
        System.out.println(":a");


    }

    public static void main(String[] args) {
        DataSave dataSave = new DataSave();
        dataSave.saveSeasonAnime();
    }
}



class SeasonJsonList{
    List<Anime> anime;
}
