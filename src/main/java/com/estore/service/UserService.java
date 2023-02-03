package com.estore.service;

import com.estore.entity.DefaultUser;
import com.estore.entity.User;

import java.security.Principal;

public interface UserService {
    User getByUserName(Principal principal);
    boolean checkUserExisting(DefaultUser theDefaultUser);
}
