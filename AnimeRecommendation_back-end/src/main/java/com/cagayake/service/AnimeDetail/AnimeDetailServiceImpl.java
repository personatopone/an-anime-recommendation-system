package com.cagayake.service.AnimeDetail;

import com.cagayake.bean.Comment;
import com.cagayake.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeDetailServiceImpl implements AnimeDetailService {

    private CommentMapper commentMapper;
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

    @Autowired
    public void setCommentMapper(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }
}
