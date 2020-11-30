package com.iot.user;

import com.iot.user.entity.Role;
import com.iot.user.entity.UserData;
import com.iot.user.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    public Role getUserRole(UserData userData){
        return  userRoleRepository.getByUserData(userData).getUserRoleName();
    }
}
