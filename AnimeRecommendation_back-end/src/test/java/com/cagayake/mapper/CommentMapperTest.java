package com.cagayake.mapper;

import com.cagayake.bean.Comment;
import com.cagayake.service.HomeServiceTest;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class CommentMapperTest {

    private static Logger logger = Logger.getLogger(CommentMapperTest.class);
    @Autowired
    private CommentMapper mapper;

    @Test
    void test(){
        Comment comment = new Comment(1,"a","a","a");
        mapper.saveComment(comment);
        Assert.notEmpty( mapper.findCommentByMal_id(1),"CommentMapper");
        logger.info("comment mapper test passed");
    }
}
