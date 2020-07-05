package com.cagayake.mapper;

import com.cagayake.bean.Genre;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper()
@Repository()
public interface GenreMapper {
    void saveGenre(Genre genre);
}
