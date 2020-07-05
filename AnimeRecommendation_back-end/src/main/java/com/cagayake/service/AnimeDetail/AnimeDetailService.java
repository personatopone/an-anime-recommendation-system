package com.cagayake.service.AnimeDetail;

import com.cagayake.bean.Anime;
import com.cagayake.bean.Comment;
import com.cagayake.bean.Song;

import java.util.List;

public interface AnimeDetailService {
    void saveComment(Comment comment);
    List<Comment> findComment(int mal_id);
    Anime findAnime(int mal_id);
    List<Song> findSong(int mal_id,String type);
}
