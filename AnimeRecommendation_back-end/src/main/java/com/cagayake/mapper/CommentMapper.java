package com.cagayake.mapper;

import com.cagayake.bean.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper()
@Repository()
public interface CommentMapper {
    void saveComment(Comment comment);
    List<Comment> findCommentByMal_id(int id);
}
