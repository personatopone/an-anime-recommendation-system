package com.cagayake.mapper;

import com.cagayake.bean.Comment;

import java.util.List;

public interface CommentMapper {
    void saveComment(Comment comment);
    List<Comment> findCommentByMal_id(int id);
}
