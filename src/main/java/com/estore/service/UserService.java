package com.estore.service;

import com.estore.entity.DefaultUser;
import com.estore.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;

public interface UserService {
    User getByUserName(Principal principal);

    boolean checkExistsUser(DefaultUser theDefaultUser);

    UserDetails loadUserByUsername(String userName);
}
