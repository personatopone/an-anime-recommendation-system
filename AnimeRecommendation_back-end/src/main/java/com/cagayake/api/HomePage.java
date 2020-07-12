package com.cagayake.api;

import com.cagayake.api.common.Response;
import com.cagayake.bean.Anime;
import com.cagayake.service.homepage.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class HomePage {


    HomePageService homePageService;

    @RequestMapping(value = "/anime/{season}/{year}",method = RequestMethod.GET,produces ="application/json")
    public Response SeasonAnime(@PathVariable String season, @PathVariable String year){
        List<Anime> animeList = homePageService.animeList(year, season);
        return new Response(200,"success",animeList);
    }

    @RequestMapping(value = "/anime/ranking",method = RequestMethod.GET,produces ="application/json")
    public Response RankingAnime(){
        return new Response(200,"success",homePageService.RankingAnime());
    }

    @RequestMapping(value = "/anime/search/{searchType}/{content}",method = RequestMethod.GET,produces ="application/json")
    public Response search(@PathVariable int searchType,@PathVariable String content){
        List<Anime> animeList = homePageService.findAnime(searchType, content);
        return new Response(200,"success",animeList);
    }

    @Autowired
    public void setHomePageService(HomePageService homePageService) {
        this.homePageService = homePageService;
    }


}
