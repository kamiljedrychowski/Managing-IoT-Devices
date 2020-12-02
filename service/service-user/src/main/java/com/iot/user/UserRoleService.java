package com.iot.user;

import com.iot.user.entity.Role;
import com.iot.user.entity.UserData;
import com.iot.user.repository.UserRoleRepository;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRoleService(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    public Role getUserRole(UserData userData){
        return  userRoleRepository.getUserRoleByUserData(userData).getUserRoleName();
    }
}
