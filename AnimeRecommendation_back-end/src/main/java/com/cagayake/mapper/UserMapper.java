package com.cagayake.mapper;

import com.cagayake.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper()
@Repository()
public interface UserMapper {
   User findUserByName(String name);
}
