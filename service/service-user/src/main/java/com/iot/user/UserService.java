package com.iot.user;

import com.iot.user.dto.UserDto;
import com.iot.user.entity.UserData;
import com.iot.user.entity.UserRole;
import com.iot.user.enums.Role;
import com.iot.user.repository.RoleRepository;
import com.iot.user.repository.UserDataRepository;
import com.iot.user.repository.UserRoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class UserService {

    private final UserDataRepository userDataRepository;
    private final UserRoleRepository userRoleRepository;
    private final UserRoleService userRoleService;
    private final RoleRepository roleRepository;

    private static final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public UserService(UserDataRepository userDataRepository, UserRoleRepository userRoleRepository, UserRoleService userRoleService, RoleRepository roleRepository) {
        this.userDataRepository = userDataRepository;
        this.userRoleRepository = userRoleRepository;
        this.userRoleService = userRoleService;
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

    public ResponseEntity<Void> login(UserDto userDto) {
        UserData userData = userDataRepository.getUserDataByUserUsername(userDto.getUsername());
        if (userData != null && bCryptPasswordEncoder.matches(userDto.getPassword(), userData.getUserPassword())) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    public ResponseEntity<String> getUserRole(UserDto userDto) {
        UserData userData = userDataRepository.getUserDataByUserUsername(userDto.getUsername());
        if (userData == null) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        com.iot.user.entity.Role userRole = userRoleService.getUserRole(userData);
        if (userRole != null) {
            return new ResponseEntity<>(userRole.getRoleName(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

}
