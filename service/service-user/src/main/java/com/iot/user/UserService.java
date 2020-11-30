package com.iot.user;

import com.iot.user.dto.UserDto;
import com.iot.user.entity.UserData;
import com.iot.user.entity.UserRole;
import com.iot.user.enums.Role;
import com.iot.user.repository.RoleRepository;
import com.iot.user.repository.UserDataRepository;
import com.iot.user.repository.UserRoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class UserService {

    private final UserDataRepository userDataRepository;
    private final UserRoleRepository userRoleRepository;
    private final RoleRepository roleRepository;

    private static final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public UserService(UserDataRepository userDataRepository, UserRoleRepository userRoleRepository, RoleRepository roleRepository) {
        this.userDataRepository = userDataRepository;
        this.userRoleRepository = userRoleRepository;
        this.roleRepository = roleRepository;
    }

    public void addUser(UserDto userDto) {
        if (userDataRepository.existsUserDataByUserUsername(userDto.getUsername())) {
            log.info("User with this username already exists");
            return;
        }

        UserData userData = UserData.builder()
                .userName(userDto.getName())
                .userPassword(bCryptPasswordEncoder.encode(userDto.getPassword()))
//                .userPassword(userDto.getPassword())
                .userUsername(userDto.getUsername())
                .userCreationTime(LocalDateTime.now())
                .build();

        userDataRepository.save(userData);

        com.iot.user.entity.Role byRoleName = roleRepository.getByRoleNameLike(Role.USER.toString().toLowerCase());
        UserRole userRole = UserRole.builder()
                .userData(userData)
                .userRoleName(byRoleName)
                .creationTime(LocalDateTime.now())
                .build();

        userRoleRepository.save(userRole);
    }

}
