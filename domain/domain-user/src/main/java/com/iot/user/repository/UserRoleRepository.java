package com.iot.user.repository;

import com.iot.user.entity.UserData;
import com.iot.user.entity.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, Long> {
    public UserRole getByUserData(UserData userData);
}
