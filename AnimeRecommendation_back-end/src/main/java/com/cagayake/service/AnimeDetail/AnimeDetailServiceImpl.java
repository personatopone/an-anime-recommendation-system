package com.cagayake.service.AnimeDetail;

import com.cagayake.bean.Anime;
import com.cagayake.bean.Comment;
import com.cagayake.bean.Song;
import com.cagayake.mapper.AnimeMapper;
import com.cagayake.mapper.CommentMapper;
import com.cagayake.mapper.SongMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeDetailServiceImpl implements AnimeDetailService {

    private CommentMapper commentMapper;
    private AnimeMapper animeMapper;
    private SongMapper songMapper;
    @Override
    public void saveComment(Comment comment) {
        commentMapper.saveComment(comment);
    }

    @Override
    public List<Comment> findComment(int mal_id) {
        if (mal_id>=0){
          return  commentMapper.findCommentByMal_id(mal_id);
        }
        return null;
    }

    @Override
    public Anime findAnime(int mal_id) {
        return animeMapper.findAnimeById(mal_id);
    }

    @Override
    public List<Song> findSong(int mal_id, String type) {

        Anime anime = animeMapper.findAnimeById(mal_id);
        anime.setClick_conut(anime.getClick_conut()+1);
        animeMapper.updateAnime(anime);
        Song song = new Song();
        song.setMal_id(mal_id);
        song.setType(type);
        return songMapper.findSongByIdAndType(song);
    }

    @Autowired
    public void setCommentMapper(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Autowired
    public void setAnimeMapper(AnimeMapper animeMapper) {
        this.animeMapper = animeMapper;
    }

    @Autowired
    public void setSongMapper(SongMapper songMapper) {
        this.songMapper = songMapper;
    }
}
