package com.cagayake.service.homepage;

import com.cagayake.bean.Anime;

import java.util.List;


public interface HomePageService {
    List<Anime> animeList(String year,String season);
}
