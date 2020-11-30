package com.iot.user.repository;

import com.iot.user.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    public Role getByRoleNameLike(String name);
}
