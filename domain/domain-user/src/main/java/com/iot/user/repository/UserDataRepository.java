package com.iot.user.repository;

import com.iot.user.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepository extends CrudRepository<UserData, Long> {
    public Boolean existsUserDataByUserUsername(String username);
}
