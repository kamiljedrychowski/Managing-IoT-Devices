package com.iot.user.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Table(name = "USER_ROLE")
@Data
public class UserRole {

    @Id
    @GeneratedValue
    @Column(name = "user_role_id")
    Long userRoleId;
    @OneToOne
    @JoinColumn(name = "role_id")
    Role userRoleName;
    @OneToOne
    @JoinColumn(name = "user_id")
    UserData userData;
    @Column(name = "user_role_creation_time")
    LocalDateTime creationTime;


}
