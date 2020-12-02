package com.iot.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Table(name = "USER_ROLE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRole {

    @Id
    @GeneratedValue
    @Column(name = "user_role_id")
    private Long userRoleId;
    @OneToOne
    @JoinColumn(name = "role_id")
    private Role userRoleName;
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserData userData;
    @Column(name = "user_role_creation_time")
    private LocalDateTime creationTime;


}
