package com.cagayake.service.AnimeDetail;

import com.cagayake.bean.Comment;

import java.util.List;

public interface AnimeDetailService {
    void saveComment(Comment comment);
    List<Comment> findComment(int mal_id);
}
