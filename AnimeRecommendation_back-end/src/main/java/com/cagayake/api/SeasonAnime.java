package com.cagayake.api;

import com.cagayake.api.common.Response;
import com.cagayake.bean.Anime;
import com.cagayake.service.homepage.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SeasonAnime {


    HomePageService homePageService;

    @RequestMapping(value = "/anime/{season}/{year}",method = RequestMethod.GET,produces ="application/json")
    public Response SeasonAnime(@PathVariable String season, @PathVariable String year){
        List<Anime> animeList = homePageService.animeList(year, season);
        return new Response(200,"success",animeList);
    }


    @Autowired
    public void setHomePageService(HomePageService homePageService) {
        this.homePageService = homePageService;
    }
}
