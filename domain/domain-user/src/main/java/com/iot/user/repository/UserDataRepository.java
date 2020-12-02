package com.iot.user.repository;

import com.iot.user.entity.UserData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepository extends CrudRepository<UserData, Long> {

    Boolean existsUserDataByUserUsername(String username);

    UserData getUserDataByUserUsername(String username);

}
