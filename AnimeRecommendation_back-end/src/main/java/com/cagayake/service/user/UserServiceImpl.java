package com.cagayake.service.user;

import com.cagayake.mapper.UserMapper;
import com.cagayake.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public User getUser(String name) {
        if (mapper.findUserByName(name)==null){
            return null;
        }else {
            return mapper.findUserByName(name);
        }
    }
}
