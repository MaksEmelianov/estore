package com.estore.service.impl;

import com.estore.entity.DefaultUser;
import com.estore.entity.User;
import com.estore.service.UserService;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User getByUserName(Principal principal) {
        return null;
    }

    @Override
    public boolean checkUserExisting(DefaultUser theDefaultUser) {
        return false;
    }
}
