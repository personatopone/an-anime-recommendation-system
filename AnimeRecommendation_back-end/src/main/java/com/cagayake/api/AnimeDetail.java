package com.cagayake.api;

import com.cagayake.api.common.Response;
import com.cagayake.bean.Anime;
import com.cagayake.bean.Comment;
import com.cagayake.bean.Song;
import com.cagayake.service.AnimeDetail.AnimeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AnimeDetail {

    private AnimeDetailService animeDetailService;

   @RequestMapping(value = "/comment/save/{username}/{time}/{comment_content}/{mal_id}",method = RequestMethod.GET,produces ="application/json")
    public Response saveComment(@PathVariable String comment_content,@PathVariable String time,@PathVariable String username,@PathVariable int mal_id ){
       Comment comment = new Comment(mal_id,username,time,comment_content);
        animeDetailService.saveComment(comment);
        return new Response(200,"save success",null);
    }

    @RequestMapping(value = "/comment/get/{mal_id}",method = RequestMethod.GET,produces ="application/json")
    public Response getComment(@PathVariable int mal_id){
        List<Comment> comments = animeDetailService.findComment(mal_id);
        return new Response(200,"success",comments);
    }

    @RequestMapping(value = "/anime/get/{mal_id}",method = RequestMethod.GET,produces ="application/json")
    public Response getAnime(@PathVariable int mal_id){
       Anime anime = animeDetailService.findAnime(mal_id);
         List<Song> songOP  = animeDetailService.findSong(mal_id,"op");
         List<Song> songED = animeDetailService.findSong(mal_id,"ed");
         Map<String,Object> data = new HashMap<>();
         data.put("anime",anime);
         data.put("op",songOP);
         data.put("ed",songED);
         return new Response(200,"success",data);
    }

    @Autowired
    public void setAnimeDetailService(AnimeDetailService animeDetailService) {
        this.animeDetailService = animeDetailService;
    }
}
