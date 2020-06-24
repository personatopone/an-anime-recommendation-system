package com.cagayake.service.user;

import com.cagayake.mapper.UserMapper;
import com.cagayake.bean.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserMapper mapper;
    private static Logger logger = Logger.getLogger(UserServiceImpl.class);
    @Override
    public User getUser(String name) {
        if (mapper.findUserByName(name)==null){
            logger.error("User"+ name +"not found");
            return null;
        }else {
            return mapper.findUserByName(name);
        }
    }

    @Autowired
    public void setMapper(UserMapper mapper) {
        this.mapper = mapper;
    }
}
